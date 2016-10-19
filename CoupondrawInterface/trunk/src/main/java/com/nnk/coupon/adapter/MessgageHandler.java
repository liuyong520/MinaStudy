package com.nnk.coupon.adapter;

import com.nnk.coupon.common.SignSecurityUtlis;
import com.nnk.coupon.handler.PharseMessageHandler;
import com.nnk.coupon.service.CouponService;
import com.nnk.coupon.service.GetSignKeyService;
import com.nnk.interfacetemplate.common.StringUtil;
import org.apache.log4j.Logger;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 14:31
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class MessgageHandler extends IoHandlerAdapter implements InterfaceDict{
    public static final Logger log = Logger.getLogger(MessgageHandler.class);
    @Autowired
    private TaskExecutor taskExecutor;
    @Autowired
    private CouponService service;
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
        session.setAttribute("UUID", UUID.randomUUID().toString().toUpperCase());
        log.info("sessionCreated:" + session.getAttribute("UUID"));
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
        log.info("sessionOpened:" + session.getAttribute("UUID"));
        log.info("sessionOpened:" + session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        log.info("session 已经关闭，释放连接");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);

    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
        log.error("exceptionCaught:"+session);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        log.info("reciver msg：" + message.toString());
        String messageString = message.toString();
        try {
            taskExecutor.execute(new PharseMessageHandler(session,messageString,service));
        } catch (Exception e) {
            String messageBody = messageString.substring(5, messageString.length());
            String[] contents = messageBody.split("~");
            String interfaceName = contents[0];
            String interfaceVersion = contents[1];
            String Command = contents[2];
            String ReqId = contents[3];
            String merid = contents[4];
            String resp = interfaceName+"~"+interfaceVersion+"~"+Command+"~"+ReqId+"~2999~其他错误~";
            ResponseSocket(session,resp,merid);
            log.error("taskExecutor error：" + message.toString());
            log.error(e.getMessage(),e);
        }


    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
        log.info("msgsend success");
    }

    @Override
    public void inputClosed(IoSession session) throws Exception {
        super.inputClosed(session);
    }

    private void ResponseSocket(IoSession session, String src,String merid) {
        String meraccount = merid.substring(0, 1) + "00000" + merid.substring(1, merid.length());
        String key = GetSignKeyService.getSignkey(merid,meraccount);
        String Sign = SignSecurityUtlis.sign(src, key);
        String responseBody = src + Sign;
        String head = StringUtil.fixedStringByzeroL(responseBody.getBytes().length + "", 5);
        log.info("生成原串：" + src + ",key：" +key + ",响应头head：" + head + ",响应体长度:" + responseBody.getBytes().length);
        String responseString = head + responseBody;
        log.info("send:" + responseString);
        if(session.isActive()){
            WriteFuture future = session.write(responseString);
            if(future.isDone()){
                log.info("send succces");
            }
        }else{
            log.info("客户端已主动关闭连接");
        }
    }



}

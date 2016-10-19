package com.nnk.coupon.handler;

import com.nnk.coupon.adapter.InterfaceDict;
import com.nnk.coupon.common.SignSecurityUtlis;
import com.nnk.coupon.entity.*;
import com.nnk.coupon.service.CouponService;
import com.nnk.coupon.service.GetSignKeyService;
import com.nnk.interfacetemplate.common.StringUtil;
import org.apache.log4j.Logger;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.IoSession;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 17:37
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class PharseMessageHandler implements InterfaceDict, Runnable {
    public static final Logger log = Logger.getLogger(PharseMessageHandler.class);
    private IoSession session;
    private String messageString;
    private ThreadLocal<String> key = new ThreadLocal<String>();
    private CouponService service;
    public PharseMessageHandler(IoSession session, String messageString,CouponService service) {
        this.session = session;
        this.messageString = messageString;
        this.service = service;
    }

    public void handlerMessage(IoSession session, String messageString) {

//        if(Integer.parseInt(messageString.substring(0, 5)) >= 0) {
//            ResponseSocket(session, messageString);
//            return;
//        }


        int msglen = Integer.parseInt(messageString.substring(0, 5));
        log.info("msglen：" + msglen);
        log.info("msg：" + messageString);
        String messageBody = messageString.substring(5, messageString.length());
        String[] contents = messageBody.split("~");
        String interfaceName = contents[0];
        String interfaceVersion = contents[1];
        String Command = contents[2];
        String ReqId = contents[3];
        if (checkSign(contents)) {
            if (OBTATIN_CARD.equals(Command)) {
                HanlderObtainCard(session, contents);
            } else if (QUERY_ALL.equals(Command)) {
                HanlderQueryAllCard(session, contents);
            } else if (QUERY_CARD.equals(Command)) {
                HandlerQueryCard(session, contents);
            } else {
                String resp = interfaceName+"~"+interfaceVersion+"~"+Command+"~"+ReqId+"~2999~协议错误请检查协议数据~";
                ResponseSocket(session,resp);
            }
        } else {
            String resp = interfaceName+"~"+interfaceVersion+"~"+Command+"~"+ReqId+"~2999~签名验证错误~";
            ResponseSocket(session,resp);
        }

    }

    private void HandlerQueryCard(IoSession session, String[] contents) {
        CouponQueryByCardRequest query = new CouponQueryByCardRequest(contents);
        CouponQueryByCardResponse response = service.queryCouponByCardId(query);
        String src = response.toSocketString();
        ResponseSocket(session, src);

    }

    private void ResponseSocket(IoSession session, String src) {
        String Sign = SignSecurityUtlis.sign(src, this.key.get());
        String responseBody = src + Sign;
        String head = StringUtil.fixedStringByzeroL(responseBody.getBytes().length + "", 5);
        log.info("生成原串：" + src + ",key：" + this.key.get() + ",响应头head：" + head + ",响应体长度:" + responseBody.getBytes().length);
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

    private boolean checkSign(String[] contents) {
        String sign = contents[contents.length - 1];
        if (contents.length >= 5) {
            String merid = contents[4];
            String meraccount = merid.substring(0, 1) + "00000" + merid.substring(1, merid.length());
            String key = GetSignKeyService.getSignkey(merid, meraccount);
            this.key.set(key);
            log.info("获取到key:" + key);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < contents.length - 1; i++) {
                sb.append(contents[i]).append("~");
            }
            return SignSecurityUtlis.checkSign(sb.toString(), key, sign);
        }
        return false;


    }

    private void HanlderQueryAllCard(IoSession session, String[] contents) {
        CouponQueryByUserIdRequest query = new CouponQueryByUserIdRequest(contents);
        CouponQueryByUserIdResponse response = service.queryCouponByUserId(query);
        String src = response.toSocketString();
        ResponseSocket(session,src);
    }



    private void HanlderObtainCard(IoSession session, String[] contents) {
        CouponObtainRequest query = new CouponObtainRequest(contents);
        CouponObtainResponse response = service.getCoupon(query);
        String src = response.toSocketString();
        ResponseSocket(session,src);
    }

    @Override
    public void run() {
        try {
            handlerMessage(session, messageString);
        } catch (Exception ex) {
            ex.printStackTrace();
            String messageBody = messageString.substring(5, messageString.length());
            String[] contents = messageBody.split("~");
            String interfaceName = contents[0];
            String interfaceVersion = contents[1];
            String Command = contents[2];
            String ReqId = contents[3];
            String resp = interfaceName+"~"+interfaceVersion+"~"+Command+"~"+ReqId+"~2999~其他错误~";
            ResponseSocket(session,resp);
            log.error(ex.getMessage(),ex);
        } finally {
            session.closeNow();
        }
    }
}

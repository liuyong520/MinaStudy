package com.nnk.coupon.test;

import com.nnk.coupon.adapter.HandlerOne;
import com.nnk.coupon.common.SignSecurityUtlis;
import com.nnk.coupon.entity.CouponCallbackRequest;
import com.nnk.coupon.service.GetSignKeyService;
import com.nnk.interfacetemplate.common.StringUtil;
import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/7/6
 * Time: 17:03
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class SocketUtils {

    public static final Logger log = Logger.getLogger(SocketUtils.class);
    //socket 回调接口
    public void send(CouponCallbackRequest request){
        NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast( "logger", new LoggingFilter() );
        connector.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName("GBK")))); //设置编码过滤器
        connector.setHandler(new HandlerOne());//设置事件处理器
        String uri = request.getUrl().replace("socket://","");
        //Ip:port
        String[] content = uri.split(":");
        ConnectFuture cf = connector.connect(
                new InetSocketAddress(content[0], Integer.parseInt(content[1])));//建立连接
        cf.awaitUninterruptibly();//等待连接创建完成
        String merid = request.getMerID();
        String meraccount = merid.substring(0, 1) + "00000" + merid.substring(1, merid.length());
        String key = GetSignKeyService.getSignkey(merid, meraccount);
        String src = request.toSocketString();
        String sign = SignSecurityUtlis.sign(src, key);
        String responseBody = src + sign;
        String head = StringUtil.fixedStringByzeroL(responseBody.length() + "", 5);
        log.info("生成原串：" + src + ",key：" + key + ",响应头head：" + head + ",响应体长度:" + responseBody.length());
        String responseString = head + responseBody;
        log.info("发送报文："+responseString);
        cf.getSession().write(responseString);//发送消息
        cf.getSession().close(true);
        cf.getSession().getCloseFuture().awaitUninterruptibly();//等待连接断开
        connector.dispose();
    }
}

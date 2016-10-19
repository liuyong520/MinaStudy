package com.nnk.coupon.test;

import com.nnk.coupon.adapter.HandlerOne;
import com.nnk.coupon.codec.CodeFactory;
import com.nnk.coupon.common.SignSecurityUtlis;
import com.nnk.interfacetemplate.common.StringUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 11:16
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class ClientTst {
    public static void main(String[] args) {
        PropertyConfigurator.configure("config/log4j.properties");
        System.out.println("=========================================================");
        final NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast( "logger", new LoggingFilter() );
        connector.getFilterChain().addLast( "codec", new ProtocolCodecFilter(new CodeFactory())); //设置编码过滤器
        connector.setHandler(new HandlerOne());//设置事件处理器
//        final ConnectFuture cf = connector.connect(
//                new InetSocketAddress("127.0.0.1", 8888 ));//建立连接
//        cf.awaitUninterruptibly();//等待连接创建完成
        for (int i = 0; i < 50 ; i++) {
            new Thread(new Runnable(){

                @Override
                public void run() {
                    String rand = com.nnk.coupon.common.DateUtil.format(new Date());
                    String sign =SignSecurityUtlis.sign("007KA_COUPON~1.1.0.0.1~002~"+rand+"~1200000232~UIpX79bi59SPrerVwsxGCOEQIr2I0=~13267191379~2~500~20160617093124~","lk839u45lqzf");
                    String msg ="007KA_COUPON~1.1.0.0.1~002~"+rand+"~1200000232~UIpX79bi59SPrerVwsxGCOEQIr2I0=~13267191379~2~500~20160617093124~"+sign;
                    String head = StringUtil.fixedStringByzeroL(msg.length() + "", 5);
                    System.out.println(head);
                    ConnectFuture cf = connector.connect(
                            new InetSocketAddress("127.0.0.1", 8888 ));//建立连接
                    cf.awaitUninterruptibly();//等待连接创建完成

                    cf.getSession().write(head + "007KA_COUPON~1.1.0.0.1~002~" + rand + "~1200000232~UIpX79bi59SPrerVwsxGCOEQIr2I0=~13267191379~2~500~20160617093124~" + sign);//发送消息
                    Logger.getLogger(this.getClass()).info("SENT:SUCCESS");

                    try
                    {
                        Thread.sleep(1000 * 10);
                    } catch (Exception e) {
                    }
                }
            }).start();

        }


//        cf.getSession().close(true);
//        cf.getSession().getCloseFuture().awaitUninterruptibly();//等待连接断开
//        connector.dispose();

        try
        {
            Thread.sleep(1000 * 300);
        } catch (Exception e) {
        }
    }
}

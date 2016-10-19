package demo;

import org.apache.log4j.PropertyConfigurator;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Properties;

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
        // 创建客户端连接器.
        NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast( "logger", new LoggingFilter() );
        connector.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName("GBK")))); //设置编码过滤器
        connector.setHandler(new HandlerOne());//设置事件处理器
        ConnectFuture cf = connector.connect(
                new InetSocketAddress("127.0.0.1", 8888));//建立连接
        cf.awaitUninterruptibly();//等待连接创建完成
        cf.getSession().write("00100VALUE1~VALUE2~VALUE3~VALUEn~sign_value");//发送消息
//        cf.getSession().close(true);
//        cf.getSession().getCloseFuture().awaitUninterruptibly();//等待连接断开
//        connector.dispose();
    }
}

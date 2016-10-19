package com.nnk.coupon.codec;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.*;

import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 14:50
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class CodeFactory implements ProtocolCodecFactory {
    private final Charset charset = Charset.forName("GBK");
    public static final Logger logger = Logger.getLogger(CodeFactory.class);
    private int prefixLength = 5;

    private int maxDataLength = 1024*100;

    private ProtocolDecoder decoder = null;
    private ProtocolEncoder encoder = null;

    public CodeFactory() {
        this(Charset.forName("GBK"));
    }
    public CodeFactory(Charset charset) {
        decoder = getNewDecoder();
        encoder = getNewEncoder();
    }

    public static ProtocolDecoder getNewDecoder() {
        return new CumulativeProtocolDecoder(){
            @Override
            protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {

                //如果长度大于5
                logger.info("resv msg len: " + in.remaining());
                if(in.remaining() >= 5) {
                    logger.info("resv msg " + in.toString());
                    //记住当前位置
                    in.mark();
                    byte[] lenbyte= new byte[5];
                    in.get(lenbyte);
                    String lenstr = new String(lenbyte);
                    Integer len = Integer.parseInt(lenstr);
                    logger.info("length=" + len + ",in.limit=" + in.limit()+",in.remaining="+in.remaining());
                    if (len - 5 > in.remaining()) {
                        in.rewind();
                        return false;
                    } else {
                        byte[] bytedata = new byte[len];
                        in.get(bytedata);
                        String body = new String(bytedata);
                        logger.info("body:" + body);
                        String text = lenstr + body;
                        logger.info("AllMsg:" + text);
                        out.write(text);
                        if(in.remaining() > 0) {
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            }
        };



    }

    public ProtocolDecoder getDecoder(IoSession session) throws Exception {
        return decoder;
    }

    public ProtocolEncoder getNewEncoder() {
       return new ProtocolEncoderAdapter() {
           @Override
           public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
               String value = (String) message;
               IoBuffer buffer = IoBuffer.allocate(value.length()).setAutoExpand(true);
               buffer.put(value.getBytes());
               if (buffer.position() > maxDataLength) {
                   throw new IllegalArgumentException("Data length: " + buffer.position());
               }
               buffer.flip();
               out.write(buffer);
           }
       };
    }

    public ProtocolEncoder getEncoder(IoSession session) throws Exception {
        return encoder;
    }
}

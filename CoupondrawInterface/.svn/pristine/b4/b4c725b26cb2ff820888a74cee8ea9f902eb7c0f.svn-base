package com.nnk.coupon.adapter;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 11:13
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class HandlerOne extends IoHandlerAdapter{

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        // TODO Auto-generated method stub
        //super.messageReceived(session, message);
        System.out.println("message :"+message);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        // TODO Auto-generated method stub
        super.sessionClosed(session);
        Logger.getLogger(this.getClass()).info("session close");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        // TODO Auto-generated method stub
        super.sessionIdle(session, status);

    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
        Logger.getLogger(this.getClass()).info("send msg£º" + message.toString());

    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {

        super.sessionCreated(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }
}

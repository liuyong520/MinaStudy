package com.nnk.coupon.service;

import nnk.msgsrv.server.MsgSrvShortConnector;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 18:55
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class MsgSrvUtil {
    private MsgSrvShortConnector connector;

    public MsgSrvUtil(String path) {
        this.connector = new MsgSrvShortConnector(path);
        this.connector.setWaitTime(30000);
    }

    public String sendAndRecieve(String appname ,String cmd ,String msg){
        String sendmsg = appname + " " + cmd + " " + msg;
        String retmsg = connector.send(sendmsg);

        return retmsg;
    }
}

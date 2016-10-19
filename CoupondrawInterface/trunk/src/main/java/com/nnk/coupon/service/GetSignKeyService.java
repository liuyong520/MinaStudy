package com.nnk.coupon.service;


import com.nnk.coupon.common.DateUtil;

import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/28
 * Time: 15:13
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class GetSignKeyService {

    public static String getSignkey(String merid,String meraccount){
        String sn =UUID.randomUUID().toString().replace("-","");
        String content = "NA NA "+ merid+" "+ meraccount + " "+ sn +" NA NA NA NA 27 NA NA NA "+ DateUtil.format(new Date())+" NA NA NA NA NA NA NA NA NA NA NA NA NA NA";
        MsgSrvUtil service = new MsgSrvUtil("config/msgsrv.xml");
        String retmsg = service.sendAndRecieve("Distributor","SlowInt",content);
        String[] contents = retmsg.split(" +");
        if(contents.length>=24){
            String key = contents[24];
            return key.substring(1,key.length()-1);
        }else {
            throw new RuntimeException("ªÒ»°key “Ï≥£");
        }

    }
}

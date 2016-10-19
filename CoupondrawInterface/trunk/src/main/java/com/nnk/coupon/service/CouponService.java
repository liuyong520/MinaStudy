package com.nnk.coupon.service;

import com.alibaba.fastjson.JSONObject;
import com.nnk.coupon.SystemConfig;
import com.nnk.coupon.common.Base64Util;
import com.nnk.coupon.common.JsonUtil;
import com.nnk.coupon.common.StringUtils;
import com.nnk.coupon.entity.*;
import com.nnk.interfacetemplate.common.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.util.Base64Utils;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/30
 * Time: 15:52
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */

public class CouponService {
    public static final Logger log = Logger.getLogger(CouponService.class);

    private SystemConfig systemConfig;

    public void setSystemConfig(SystemConfig systemConfig) {
        this.systemConfig = systemConfig;
    }

    public CouponObtainResponse getCoupon(CouponObtainRequest request) {
        log.info("获取优惠券请求：用户手机号" + request.getMerUserPhone() + "用户：" + request.getMerUserID());
        if(StringUtil.isEmpty(request.getUseType())){
            request.setUseType(systemConfig.getUseType());
            request.setMerUserRealName("");
        }

        String retmsg = sendAndRecieve(systemConfig.getServiceAppname(), "ObtainCoupon", request);
        String[] retmsgContent = retmsg.split(" +");
        String retjson = retmsgContent[4];
        log.info("服务端返回数据：sn：" + retmsgContent[2] + ",base64json：" + retjson);

        retjson = Base64Util.decode(retjson);
//        retjson = new String(Base64Utils.decode(retjson.getBytes()));
        log.info("服务端返回数据：sn：" + retmsgContent[2] + ",json：" + retjson);
        CouponObtainResponse response = JSONObject.parseObject(retjson, CouponObtainResponse.class);
        return response;
    }

    public CouponQueryByCardResponse queryCouponByCardId(CouponQueryByCardRequest request) {
        log.info("查询优惠券请求根据优惠券ID：" + request.getCardNo());
        String retmsg = sendAndRecieve(systemConfig.getServiceAppname(), "QueryCouponByCard", request);
        String[] retmsgContent = retmsg.split(" +");
        String retjson = retmsgContent[4];
        log.info("服务端返回数据：sn：" + retmsgContent[2] + ",base64json：" + retjson);
        retjson = Base64Util.decode(retjson);
        log.info("服务端返回数据：sn：" + retmsgContent[2] + ",json：" + retjson);
        CouponQueryByCardResponse response = JSONObject.parseObject(retjson, CouponQueryByCardResponse.class);
        return response;
    }


    public CouponQueryByUserIdResponse queryCouponByUserId(CouponQueryByUserIdRequest request) {
        log.info("查询优惠券请求根据用户ID：" + request.getMerUserID());
        String retmsg = sendAndRecieve(systemConfig.getServiceAppname(), "QueryCouponByUser", request);
        if(StringUtil.isEmpty(retmsg)){
            log.error(request.getReqID() + "查券返回数据为空");
        }
        String[] retmsgContent = retmsg.split(" +");
        String retjson = retmsgContent[4];

        log.info("服务端返回数据：sn：" + retmsgContent[2] + ",base64json：" + retjson);
        retjson = Base64Util.decode(retjson);
//        retjson = new String(Base64Utils.decode(retjson.getBytes()));
        log.info("服务端返回数据：sn：" + retmsgContent[2] + ",json：" + retjson);
        CouponQueryByUserIdResponse response = JSONObject.parseObject(retjson, CouponQueryByUserIdResponse.class);
        return response;
    }

    private String sendAndRecieve(String app, String cmd, Object msgObj) {
        String encrypt = systemConfig.isEncrypt() + "";
        String sn = UUID.randomUUID().toString().replace("-", "");
        String json = JsonUtil.buildJson(msgObj);
        log.debug("json:" + json);
        String base64Json = Base64Util.encode(json);
        // String base64Json = Base64Utils.encodeToString(json.getBytes());
        String msg = sn + " " + encrypt +" "+ base64Json;
        MsgSrvUtil msgSrvUtil = new MsgSrvUtil("config/msgsrv1.xml");
        return msgSrvUtil.sendAndRecieve(app, cmd, msg);
    }
}

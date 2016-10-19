package com.nnk.coupon.handler;

import com.alibaba.fastjson.JSONObject;
import com.nnk.coupon.common.Base64Util;
import com.nnk.coupon.entity.CouponCallbackRequest;
import com.nnk.coupon.test.SocketUtils;
import com.nnk.interfacetemplate.common.StringUtil;
import com.nnk.utils.http.exception.NetWorkException;
import com.nnk.utils.http.utils.HttpClientUtils;
import nnk.msgsrv.server.Request;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/7/6
 * Time: 15:43
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class MsgsrvHandler {
    public static final Logger log = Logger.getLogger(MsgsrvHandler.class);
    //处理回调通知接口
    public void notify(Request request){
        String[] contents = request.getContent().split(" +");
        String base64Json = contents[0];
        String json = Base64Util.decode(base64Json);
        log.info("收到回调通知请求：" + json);
        CouponCallbackRequest couponCallbackRequest = JSONObject.parseObject(json, CouponCallbackRequest.class);
        String url = couponCallbackRequest.getUrl();
        if(StringUtil.isNotEmpty(url)&&url.startsWith("http")){
            HttpClientUtils httpClientUtils = new HttpClientUtils();
            try {
                String resp = httpClientUtils.doPost(couponCallbackRequest.getUrl(),couponCallbackRequest);
                if(resp!=null){
                    Response(request,"suceess");
                }
            } catch (NetWorkException e) {
                e.printStackTrace();
                Response(request,"fail");
            }
        }else if(StringUtil.isNotEmpty(url)&&url.startsWith("socket")){
            try {
                SocketUtils socketUtils = new SocketUtils();
                socketUtils.send(couponCallbackRequest);
                Response(request,"suceess");
            }catch (Exception ex){
                Response(request,"fail");
            }
        }

    }
    private void Response(Request request ,String result ){
        String[] contents = request.getContent().split(" +");
        String[] cloneContents = Arrays.copyOfRange(contents, 0, contents.length+1);
        cloneContents[contents.length]= result;
        request.response(StringUtil.transitionProtocol(cloneContents));
    }
}

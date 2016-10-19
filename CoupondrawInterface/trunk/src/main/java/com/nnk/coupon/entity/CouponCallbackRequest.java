package com.nnk.coupon.entity;

import com.nnk.coupon.common.PostFormUtils;
import com.nnk.coupon.common.ReflectUtils;
import com.nnk.coupon.common.SignSecurityUtlis;
import com.nnk.coupon.service.GetSignKeyService;
import com.nnk.interfacetemplate.common.StringUtil;
import com.nnk.utils.http.interfaces.HttpData;
import org.apache.http.HttpEntity;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/7/6
 * Time: 16:41
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class CouponCallbackRequest extends HttpData implements StringSerialable {
    private String InterfaceName;
    private String InterfaceVersion;
    private String Command;
    private String ReqID;
    private String MerID;
    private String MerUserID;
    private String CardNo;
    private String CardAmt;
    private String State;
    private String DeadLine;
    private String Type;
    private String ReqTime;
    private String Sign;
    private String url;

    public CouponCallbackRequest() {
        InterfaceName = "";
        InterfaceVersion = "";
        Command = "";
        ReqID = "";
        MerID = "";
        MerUserID = "";
        CardNo = "";
        CardAmt = "";
        State = "";
        DeadLine = "";
        Type = "";
        ReqTime = "";
        Sign = "";
        url = "";
    }

    public String getInterfaceName() {
        return InterfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        InterfaceName = interfaceName;
    }

    public String getInterfaceVersion() {
        return InterfaceVersion;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        InterfaceVersion = interfaceVersion;
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        Command = command;
    }

    public String getReqID() {
        return ReqID;
    }

    public void setReqID(String reqID) {
        ReqID = reqID;
    }

    public String getMerID() {
        return MerID;
    }

    public void setMerID(String merID) {
        MerID = merID;
    }

    public String getMerUserID() {
        return MerUserID;
    }

    public void setMerUserID(String merUserID) {
        MerUserID = merUserID;
    }

    public String getCardNo() {
        return CardNo;
    }

    public void setCardNo(String cardNo) {
        CardNo = cardNo;
    }

    public String getCardAmt() {
        return CardAmt;
    }

    public void setCardAmt(String cardAmt) {
        CardAmt = cardAmt;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getDeadLine() {
        return DeadLine;
    }

    public void setDeadLine(String deadLine) {
        DeadLine = deadLine;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getReqTime() {
        return ReqTime;
    }

    public void setReqTime(String reqTime) {
        ReqTime = reqTime;
    }

    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {
        Sign = sign;
    }

    @Override
    public HttpEntity getPostdata() {
        String src = toHttpString();
        String meraccount = MerID.substring(0, 1) + "00000" + MerID.substring(1, MerID.length());
        String key = GetSignKeyService.getSignkey(MerID, meraccount);
        Sign = SignSecurityUtlis.sign(src, key);
        return PostFormUtils.buildEntity(this, "url", false);
    }

    public String toHttpString() {
        checkField();
        String respsrc = ReflectUtils.getkeyValueString(this, "=", "&", "Sign", "url");
        return respsrc;
    }

    private void checkField() {
        InterfaceName = StringUtil.isEmpty(InterfaceName) ? "007KA_COUPON" : InterfaceName;
        InterfaceVersion = StringUtil.isEmpty(InterfaceVersion) ? "1.0.0.1" : InterfaceVersion;
        Command = StringUtil.isEmpty(Command) ? "004" : Command;
        ReqID = StringUtil.isEmpty(ReqID)? UUID.randomUUID().toString().replace("-",""):ReqID;
    }

    @Override
    public String getGetdata() {
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toSocketString() {
        checkField();
        String str = StringUtil.getAppendStrByValue(this, "Sign", "~");
        return str;
    }
}

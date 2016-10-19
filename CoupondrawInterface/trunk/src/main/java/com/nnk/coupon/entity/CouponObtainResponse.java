package com.nnk.coupon.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.nnk.interfacetemplate.common.StringUtil;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 15:19
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class CouponObtainResponse implements StringSerialable {
    protected String InterfaceName;
    protected String InerfaceVersion;
    protected String Command;
    protected String ReqID;
    protected String Result;
    protected String ReMsg;
    private String CardNo;
    private String CardAmt;
    private String DeadLine;
    protected String ReqTime;
    protected String Sign;

    @JSONField(name = "InterfaceName")
    public String getInterfaceName() {
        return InterfaceName;
    }
    @JSONField(name = "InerfaceVersion")
    public String getInerfaceVersion() {
        return InerfaceVersion;
    }
    @JSONField(name = "Command")
    public String getCommand() {
        return Command;
    }
    @JSONField(name = "ReqID")
    public String getReqID() {
        return ReqID;
    }
    @JSONField(name = "Result")
    public String getResult() {
        return Result;
    }
    @JSONField(name = "ReMsg")
    public String getReMsg() {
        return ReMsg;
    }
    @JSONField(name = "ReqTime")
    public String getReqTime() {
        return ReqTime;
    }
    @JSONField(name = "Sign")
    public String getSign() {
        return Sign;
    }
    @JSONField(name = "CardNo")
    public String getCardNo() {
        return CardNo;
    }
    @JSONField(name = "CardAmt")
    public String getCardAmt() {
        return CardAmt;
    }
    @JSONField(name = "DeadLine")
    public String getDeadLine() {
        return DeadLine;
    }

    public void setInterfaceName(String interfaceName) {
        InterfaceName = interfaceName;
    }

    public void setInerfaceVersion(String inerfaceVersion) {
        InerfaceVersion = inerfaceVersion;
    }

    public void setCommand(String command) {
        Command = command;
    }

    public void setReqID(String reqID) {
        ReqID = reqID;
    }

    public void setResult(String result) {
        Result = result;
    }

    public void setReMsg(String reMsg) {
        ReMsg = reMsg;
    }

    public void setReqTime(String reqTime) {
        ReqTime = reqTime;
    }

    public void setSign(String sign) {
        Sign = sign;
    }

    public void setCardNo(String cardNo) {
        CardNo = cardNo;
    }

    public void setCardAmt(String cardAmt) {
        CardAmt = cardAmt;
    }

    public void setDeadLine(String deadLine) {
        DeadLine = deadLine;
    }

    @Override
    public String toSocketString() {
        String str = StringUtil.getAppendStrByValue(this,"Sign","~");
        return str;
    }


}

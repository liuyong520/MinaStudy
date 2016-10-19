package com.nnk.coupon.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.nnk.interfacetemplate.common.StringUtil;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 15:24
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class CouponQueryByUserIdResponse implements StringSerialable {
    protected String InterfaceName;
    protected String InerfaceVersion;
    protected String Command;
    protected String ReqID;
    protected String Result;
    protected String ReMsg;
    private String CardNoList;
    private String CardAmtList;
    private String StateList;
    private String DeadLineList;
    private String TypeList;
    protected String ReqTime;
    protected String Sign;

    @JSONField(name = "StateList")
    public String getStateList() {
        return StateList;
    }
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
    @JSONField(name = "CardNoList")
    public String getCardNoList() {
        return CardNoList;
    }
    @JSONField(name = "CardAmtList")
    public String getCardAmtList() {
        return CardAmtList;
    }
    @JSONField(name = "DeadLineList")
    public String getDeadLineList() {
        return DeadLineList;
    }
    @JSONField(name = "TypeList")
    public String getTypeList() {
        return TypeList;
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

    public void setCardNoList(String cardNoList) {
        CardNoList = cardNoList;
    }

    public void setCardAmtList(String cardAmtList) {
        CardAmtList = cardAmtList;
    }


    public void setDeadLineList(String deadLineList) {
        DeadLineList = deadLineList;
    }

    public void setTypeList(String typeList) {
        TypeList = typeList;
    }

    public void setStateList(String stateList) {
        StateList = stateList;
    }

    @Override
    public String toString() {
        return "CouponQueryByUserIdResponse{" +
                "InterfaceName='" + InterfaceName + '\'' +
                ", InerfaceVersion='" + InerfaceVersion + '\'' +
                ", Command='" + Command + '\'' +
                ", ReqID='" + ReqID + '\'' +
                ", Result='" + Result + '\'' +
                ", ReMsg='" + ReMsg + '\'' +
                ", ReqTime='" + ReqTime + '\'' +
                ", Sign='" + Sign + '\'' +
                ", CardNoList='" + CardNoList + '\'' +
                ", CardAmtList='" + CardAmtList + '\'' +
                ", DeadLineList='" + DeadLineList + '\'' +
                ", TypeList='" + TypeList + '\'' +
                '}';
    }

    @Override
    public String toSocketString() {
        String str = StringUtil.getAppendStrByValue(this, "Sign", "~");
        return str;
    }
}

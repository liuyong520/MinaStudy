package com.nnk.coupon.entity;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 15:15
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class CouponObtainRequest implements IRequest{
    private String InterfaceName;
    private String InterfaceVersion;
    private String Command;
    private String ReqID;
    private String MerID;
    private String ReqTime;
    private String Sign;
    private String MerUserID;
    private String MerUserPhone;
    private String CardAmt;
    private String Type;
    private String useType;
    private String MerUserRealName;
    public CouponObtainRequest() {
    }

    public String getMerUserRealName() {
        return MerUserRealName;
    }

    public void setMerUserRealName(String merUserRealName) {
        MerUserRealName = merUserRealName;
    }

    public String getInterfaceName() {
        return InterfaceName;
    }

    public String getInterfaceVersion() {
        return InterfaceVersion;
    }

    public String getCommand() {
        return Command;
    }

    public String getReqID() {
        return ReqID;
    }

    public String getMerID() {
        return MerID;
    }

    public String getReqTime() {
        return ReqTime;
    }

    public String getSign() {
        return Sign;
    }

    public String getMerUserID() {
        return MerUserID;
    }

    public String getMerUserPhone() {
        return MerUserPhone;
    }

    public String getCardAmt() {
        return CardAmt;
    }

    public String getType() {
        return Type;
    }

    public String getUseType() {
        return useType;
    }

    public void setInterfaceName(String interfaceName) {
        InterfaceName = interfaceName;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        InterfaceVersion = interfaceVersion;
    }

    public void setCommand(String command) {
        Command = command;
    }

    public void setReqID(String reqID) {
        ReqID = reqID;
    }

    public void setMerID(String merID) {
        MerID = merID;
    }

    public void setReqTime(String reqTime) {
        ReqTime = reqTime;
    }

    public void setSign(String sign) {
        Sign = sign;
    }

    public void setMerUserID(String merUserID) {
        MerUserID = merUserID;
    }

    public void setMerUserPhone(String merUserPhone) {
        MerUserPhone = merUserPhone;
    }

    public void setCardAmt(String cardAmt) {
        CardAmt = cardAmt;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public CouponObtainRequest(String[] content ) {
        try {
            this.InterfaceName = content[0];
            this.InterfaceVersion = content[1];
            this.Command = content[2];
            this.ReqID = content[3];
            this.MerID = content[4];
            this.MerUserID = content[5];
            this.MerUserPhone = content[6];
            this.Type = content[7];
            this.CardAmt = content[8];
            this.ReqTime = content[9];
            this.Sign = content[10];
        }catch (Exception e){
            throw new IllegalArgumentException("获取优惠劵协议解析异常");
        }
    }

    @Override
    public String toString() {
        return "CouponObtainRequest{" +
                "InterfaceName='" + InterfaceName + '\'' +
                ", InterfaceVersion='" + InterfaceVersion + '\'' +
                ", Command='" + Command + '\'' +
                ", ReqID='" + ReqID + '\'' +
                ", MerID='" + MerID + '\'' +
                ", ReqTime='" + ReqTime + '\'' +
                ", Sign='" + Sign + '\'' +
                ", MerUserID='" + MerUserID + '\'' +
                ", MerUserPhone='" + MerUserPhone + '\'' +
                ", CardAmt='" + CardAmt + '\'' +
                ", Type='" + Type + '\'' +
                ", useType='" + useType + '\'' +
                '}';
    }
}

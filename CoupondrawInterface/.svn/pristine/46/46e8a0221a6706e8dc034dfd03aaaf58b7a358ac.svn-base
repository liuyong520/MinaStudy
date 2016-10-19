package com.nnk.coupon.entity;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 15:31
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class CouponQueryByCardRequest implements IRequest{
    protected String InterfaceName;
    protected String InterfaceVersion;
    protected String Command;
    protected String ReqID;
    protected String MerID;
    protected String ReqTime;
    protected String Sign;
    private String CardNo;

    public CouponQueryByCardRequest() {
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

    public String getCardNo() {
        return CardNo;
    }

    public void setCardNo(String cardNo) {
        CardNo = cardNo;
    }

    public CouponQueryByCardRequest(String[] content ) {
        try {
            this.InterfaceName = content[0];
            this.InterfaceVersion = content[1];
            this.Command = content[2];
            this.ReqID = content[3];
            this.MerID = content[4];
            this.CardNo = content[5];
            this.ReqTime = content[6];
            this.Sign = content[7];
        }catch (Exception e){
            throw new IllegalArgumentException("获取优惠劵协议解析异常");
        }
    }

    @Override
    public String toString() {
        return "CouponQueryByCardRequest{" +
                "InterfaceName='" + InterfaceName + '\'' +
                ", InterfaceVersion='" + InterfaceVersion + '\'' +
                ", Command='" + Command + '\'' +
                ", ReqID='" + ReqID + '\'' +
                ", MerID='" + MerID + '\'' +
                ", ReqTime='" + ReqTime + '\'' +
                ", Sign='" + Sign + '\'' +
                ", CardNo='" + CardNo + '\'' +
                '}';
    }
}

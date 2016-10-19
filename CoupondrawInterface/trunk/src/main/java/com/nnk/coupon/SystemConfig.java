package com.nnk.coupon;

import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/30
 * Time: 18:37
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
//@ConfigurationProperties(prefix = "system",locations ="file:config/System.properties")
public class SystemConfig {
    private Logger log = Logger.getLogger(SystemConfig.class);
    private String serviceAppname;
    private String useType;
    private boolean encrypt = true;
    public String getServiceAppname() {
        return serviceAppname;
    }

    public void setServiceAppname(String serviceAppname) {
        this.serviceAppname = serviceAppname;
        log.info("init ServiceAppname : " + serviceAppname);
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
        log.info("init useType : " + useType);
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
        log.info("init encrypt : " + encrypt);
    }
}

package com.nnk.coupon;


import nnk.msgsrv.server.MsgSrvLongConnector;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 11:09
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ComponentScan("com.nnk.coupon")
@EnableAutoConfiguration
@ImportResource("classpath:context/bean.xml")
public class Main extends SpringBootServletInitializer {

    public static final Logger LOGGER = Logger.getLogger(Main.class);
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        MsgSrvLongConnector connector = new MsgSrvLongConnector("config/msgsrv1.xml");
        connector.start();
    }
}

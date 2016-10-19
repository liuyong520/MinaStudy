package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/6/27
 * Time: 11:09
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class main {
    public static void main(String[] args) {
//        context/bean.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:context/bean.xml");
    }
}

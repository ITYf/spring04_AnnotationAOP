package top.ityf.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.ityf.service.AccountService;

/**
 * ClassName:AOPTest
 * Package: top.ityf.test
 * Description: 测试AOP的配置
 *
 * @Date: 2020/2/15 11:29
 * @Author: YanFei
 */
public class AOPTest {
    public static void main(String[] args) {
        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        //3、执行方法
        as.saveAccount();
    }
}

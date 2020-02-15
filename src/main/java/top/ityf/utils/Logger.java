package top.ityf.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleUnresolved;

/**
 * ClassName:Logger
 * Package: top.ityf.utils
 * Description: 用于记录日志的工具类，它里面提供了公用的方法
 *
 * @Date: 2020/2/13 18:16
 * @Author: YanFei
 */
@Component("logger")
@Aspect  //表示当前类是一个切面类(通知类)
public class Logger {
    @Pointcut("execution(* top.ityf.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 前置通知
     * 用于打印日志，计划让其在切入点方法执行之前执行(切入点方法就是业务层方法)
     */
//    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("前置通知的beforePrintLog()方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
//    @AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("后置通知的afterReturningPrintLog()方法开始记录日志了。。。");
    }

    /**
     * 异常通知
     */
//    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知的afterThrowingPrintLog()方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
//    @After("pt1()")
    public void afterPrintLog() {
        System.out.println("最终通知的afterPrintLog()方法开始记录日志了。。。");
    }

    /**
     * 环绕通知
     * 注意：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理中的环绕通知有明确的切入点方法调用，而这里的通知代码中没有
     * 解决：
     *      spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类以供使用。
     * spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            //得到方法执行所需的参数
            Object[] args = pjp.getArgs();
            System.out.println("前置通知的aroundPrintLog()方法开始记录日志了。。。");
            //明确调用业务层方法(切入点方法)
            rtValue = pjp.proceed(args);
            System.out.println("后置通知的aroundPrintLog()方法开始记录日志了。。。");
            return rtValue;
        } catch (Throwable t) {
            System.out.println("异常通知的aroundPrintLog()方法开始记录日志了。。。");
            throw new RuntimeException(t);
        } finally {
            System.out.println("最终通知的aroundPrintLog()方法开始记录日志了。。。");
        }
    }
}

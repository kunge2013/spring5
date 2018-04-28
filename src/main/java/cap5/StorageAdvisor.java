package cap5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.lang.annotation.Annotation;

//日志的处理
@Aspect
public class StorageAdvisor {

    @Before("execution(* chop(..))")
    public void beforeAttack(JoinPoint point)
    {
        System.out.println("Advice: " + point.getTarget().getClass().getSimpleName() + "蓄力");
    }

    //多条件进入方法
    @After("execution(* block(..)) && args(param) && @target(org.springframework.transaction.annotation.Transactional)" )
    public void afterAttack(JoinPoint point, String param)
    {
        System.out.println(param+"配置了事物  org.springframework.transaction.annotation.Transactional " + "进入执行");
        System.out.println("Advice: " + point.getTarget().getClass().getSimpleName() + "蓄力使用完");
    }

    @Around("execution(* chop(..))")
    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("执行之前:"+proceedingJoinPoint.getTarget());
        Object obj =  proceedingJoinPoint.proceed();
        System.out.println("执行之后:"+obj);
    }
}

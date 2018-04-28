package cap5.weaving;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

public class ProfileAspect {
    @Around("profileMethod()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch sw = new StopWatch(getClass().getName());
        try {
            sw.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            sw.stop();
            System.err.println(sw.prettyPrint());
        }
    }
    @Pointcut("execution(public * *.*.*(..))")
    public void profileMethod() {
        System.out.println("profileMethod..");
    }
}

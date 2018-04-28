package cap5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class StorageAdvisor {
    @Before("execution(* chop(..))")
    public void beforeAttack(JoinPoint point) {
        System.out.println("Advice: " + point.getTarget().getClass().getSimpleName() + "蓄力");
    }
}

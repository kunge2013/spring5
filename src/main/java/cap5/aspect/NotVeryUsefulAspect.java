package cap5.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class NotVeryUsefulAspect {

    @Pointcut("execution(* transfer(..))")
    public int  anyOldTransfer(){
        System.out.println("进入切入点");
        return  0;
    }
}

package cap5.aop;

import cap5.aop.dao.Pojo;
import org.springframework.aop.framework.AopContext;

public class SimplePojo implements Pojo{

    @Override
    public void foo() {
        ((Pojo) AopContext.currentProxy()).bar();
    }

    @Override
    public void bar() {
        System.out.println("bar");
    }
}

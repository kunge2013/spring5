package cap1.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareT implements ApplicationContextAware {
    static ApplicationContext ctx ;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx =    applicationContext;
    }

    public static Object  getBean(String beanName){
        return ctx.getBean(beanName);
    }
}

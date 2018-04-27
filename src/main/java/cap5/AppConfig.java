package cap5;

import cap1.Config.ConfigB;
import cap1.Config.DataSourceConfig;
import cap1.applicationEvent.BlackListEvent;
import cap1.applicationEvent.EmailService;
import cap1.aware.ApplicationContextAwareT;
import cap1.aware.EnvironmentAwareT;
import cap1.aware.MessageSourceAwareT;
import cap1.com.Qualifier.PlayMoviesService;
import cap1.com.Qualifier.SingerService2;
import cap1.com.bean.A;
import cap1.com.bean.B;
import cap1.com.order.Results;
import cap1.com.primary.SingerService;
import cap1.resourceLoader.PropertiesUtils;
import cap5.aop.SimplePojo;
import cap5.aop.advice.RetryAdvice;
import cap5.aop.dao.Pojo;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Method;
import java.util.Locale;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);

        factory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("执行之前");
            }
        });

        Pojo pojo = (Pojo) factory.getProxy();
        // this is a method call on the proxy!
        pojo.foo();
    }

}

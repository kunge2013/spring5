import cap1.Config.ConfigB;
import cap1.Config.DataSourceConfig;
import cap1.applicationEvent.BlackListEvent;
import cap1.applicationEvent.EmailService;
import cap1.aware.ApplicationContextAwareT;
import cap1.aware.EnvironmentAwareT;
import cap1.aware.MessageSourceAwareT;
import cap1.com.Qualifier.SingerService2;
import cap1.com.Qualifier.PlayMoviesService;
import cap1.com.bean.A;
import cap1.com.bean.B;
import cap1.com.order.Results;
import cap1.com.primary.SingerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import cap1.resourceLoader.PropertiesUtils;
import org.springframework.context.annotation.ImportResource;

import java.util.Locale;
@ImportResource("classpath*:*4.xml")
public class AppConfig {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        MyServiceImpl o = (MyServiceImpl)context.getBean("myService");
//        System.out.println(o.getName());

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigB.class);
        A a = context.getBean(A.class);
        B b = context.getBean(B.class);
        DataSourceConfig dsc = context.getBean(DataSourceConfig.class);
        ConfigB bc = (ConfigB) context.getBean(ConfigB.class);


        System.out.println(a);
        System.out.println(b);
        System.out.println(bc.getName());
        System.out.println(dsc.dataSource());
        // order 测试
        Results results = (Results)context.getBean("results");
        System.out.println(results);
        // primary
        SingerService singerService = (SingerService)context.getBean("singerService");
        System.out.println(singerService.sing());

//        singerService2
        SingerService2 singerService2 = (SingerService2)context.getBean("singerService2");
        System.out.println(singerService2.sing());

        //
        PlayMoviesService player = (PlayMoviesService)context.getBean("playMoviesService");
        System.out.println( player.showMovie().moveType());
        System.out.println( player.showMovie2().moveType());


        PlayMoviesService player2 = (PlayMoviesService)context.getBean("playMoviesService");
        System.out.println( player2.showMovie().moveType());
        System.out.println( player2.showMovie2().moveType());

        System.out.println(player.hashCode() == player2.hashCode());



//        ApplicationContext context2 = new AnnotationConfigApplicationContext(ConfigProp.class);
//        ConfigProp po =  context2.getBean(ConfigProp.class);
//        System.out.println(po.testBean().getName());

        String info1=context.getMessage("info", new String[]{"张三"}, Locale.getDefault());
        String info2=context.getMessage("info", new String[]{"张三"}, Locale.CHINA);
        String info3=context.getMessage("info", new String[]{"张三"}, Locale.ENGLISH);
        System.out.println("info1=="+info1);
        System.out.println("info2==" + info2);
        System.out.println("info3==" + info3);

        EmailService emailService =  (EmailService)context.getBean(EmailService.class);
        emailService.sendEmail("john.doe@example.org","aa");
        BlackListEvent event = new BlackListEvent(EmailService.class, "aa", "bbb");

        context.publishEvent(event);
        //资源文件配置

        System.out.println(PropertiesUtils.get("service.version"));

        // context 的获取
        EmailService emailService2 =  (EmailService) ApplicationContextAwareT.getBean("emailService");
        System.out.println(emailService2.hashCode() == emailService.hashCode());

        System.out.println(EnvironmentAwareT.get("service.version"));
        System.out.println(MessageSourceAwareT.getMessage("info"));


    }

}

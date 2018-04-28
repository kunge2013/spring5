package cap5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:*5.xml"})
public class AppTest {
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppTest.class);
//        Horseman hm = (Horseman)context.getBean("horseman");
//        hm.rush("Ghoul");
//        hm.chop("Ghoul");
        Swordman sm = (Swordman)context.getBean("swordman");
        sm.block("Ghoul");
        sm.chop("Ghoul");
    }
}

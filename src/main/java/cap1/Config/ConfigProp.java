package cap1.Config;

import cap1.com.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:app.properties")
public class ConfigProp{
    @Autowired
    Environment env;

    @Bean
    public Person testBean() {
        Person testBean = new Person();
        testBean.setName(env.getProperty("persion.name"));
        return testBean;
    }


}

package cap1.Config;

import cap1.com.bean.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {
    @Bean
    public A a(){
        return new A();
    }
}

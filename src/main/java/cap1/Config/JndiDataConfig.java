package cap1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("pro")
public class JndiDataConfig {
    JndiDataConfig(){
        System.out.println("pro");
    }
    String txt;

    @Bean
    public String dev(){
        txt = new String("dev");
        return txt;
    }
}

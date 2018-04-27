package cap1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class StandaloneDataConfig {
    StandaloneDataConfig(){
        System.out.println("dev");
    }
    String txt ;
    @Bean
    public String dev(){
        txt = new String("dev");
        return txt;
    }

}

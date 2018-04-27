package cap1.Config;

import cap1.com.bean.B;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({ConfigA.class,DataSourceConfig.class})
@ImportResource("classpath*:*2.xml")
public class ConfigB {

    @Value("${service.name}")
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Bean
    public B b() {
        return new B();
    }

}

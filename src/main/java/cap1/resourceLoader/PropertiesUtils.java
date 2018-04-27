package cap1.resourceLoader;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import java.util.Properties;

public class PropertiesUtils implements InitializingBean {

    static  Properties properties;

    private Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        properties = new Properties();
        properties.load(this.resource.getInputStream());
    }

    public static String get(String key){
        return (String) properties.get(key);
    }
}

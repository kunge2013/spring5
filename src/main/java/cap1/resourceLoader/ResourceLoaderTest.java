package cap1.resourceLoader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

public class ResourceLoaderTest {
    public static void main(String[] args) throws IOException {
        ResourceLoader loader = new DefaultResourceLoader();
        Resource setup = loader.getResource("classpath:/app.properties");
        System.out.println(setup.getFile());

        Resource txt = loader.getResource("file://C:\\Users\\Administrator\\Desktop\\脚本字段添加.sql");
        System.out.println(txt.getFile());

        Resource xsd = loader.getResource("http://www.springframework.org/schema/beans/spring-beans-4.1.xsd");
        System.out.println(xsd.getURI());
        System.out.println(xsd.getInputStream());

        Resource log = loader.getResource("context.proterties");
        System.out.println(log.getFile());
    }
}

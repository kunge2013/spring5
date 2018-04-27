package cap1.aware;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EnvironmentAwareT implements EnvironmentAware {
   static Environment environment;
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public static  Object   get(String pname){
      return  environment.getProperty(pname);
    }
}

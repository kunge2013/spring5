package cap1.factory;

import cap1.com.bean.A;
import org.springframework.beans.factory.FactoryBean;

public class FirstFactoryBean implements FactoryBean {
    private String type;

    @Override
    public Object getObject() throws Exception {
        if("a".equals(type)){
            return new A();
        }else{
            return new A();
        }

    }

    @Override
    public Class getObjectType() {
        return A.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

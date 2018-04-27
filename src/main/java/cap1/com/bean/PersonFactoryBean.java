package cap1.com.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 *
 */
public class PersonFactoryBean implements FactoryBean<Person> {
    private String personInfo;
    public Person getObject() throws Exception {
        Person person = new Person();
        String[] infos = personInfo.split(",");
        person.setName(infos[0]);
        person.setAddress(infos[1]);
        person.setAge(Integer.parseInt(infos[2]));
        return person;
    }

    public Class<Person> getObjectType() {
        return Person.class;
    }

    public boolean isSingleton() {
        return true;
    }
}

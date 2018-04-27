package cap3.validator;

import cap3.bean.Person;
import org.springframework.validation.*;

import java.util.ArrayList;
import java.util.List;

public class PersonValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }
    @Override
    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "age", "age.empty");
        Person p = (Person) obj;
        if (p.getAge() !=null && p.getAge() < 0) {
            e.rejectValue("age", "too.darn.young");
        } else if (p.getAge() !=null && p.getAge() > 110) {
            e.rejectValue("age", "too.darn.old");
        }
    }
    public   List<ObjectError> validate(Person person) {
        if(this.supports(Person.class))
        {
            BindException errors = new BindException(person, "person");
            this.validate(person,errors);
            List<ObjectError> allErrors = errors.getAllErrors();
            return allErrors;
        }

        return new ArrayList<ObjectError>();
    }
}

package cap3.wrapper;

import cap3.bean.Company;
import cap3.bean.Employee;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

/**
 * 对象包装
 */
public class BeanWrapperUtil {

    public static Object wrapperCompany(Company cy){
        BeanWrapper company = new BeanWrapperImpl(cy);
        // setting the company name..
        company.setPropertyValue("name", "Some Company Inc.");
        // ... can also be done like this:
        PropertyValue value = new PropertyValue("name", "Some Company Inc.");
        company.setPropertyValue(value);

        // ok, let's create the director and tie it to the company:
        BeanWrapper jim = new BeanWrapperImpl(new Employee());
        jim.setPropertyValue("name", "Jim Stravinsky");
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());

        // retrieving the salary of the managingDirector through the company
        Float salary = (Float) company.getPropertyValue("managingDirector.salary");
        return   company.getWrappedInstance();
    }

    public static void main(String[] args)
    {
        Company company = (Company) wrapperCompany(new Company());
    }

}

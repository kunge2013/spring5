package cap3;

import cap3.bean.Company;
import cap3.bean.Person;
import cap3.config.Config;
import cap3.edit.type.CustomerDate;
import cap3.validator.PersonValidator;
import cap3.wrapper.BeanWrapperUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.convert.ConversionService;

import java.util.Date;

@Configuration
//@Import({Config.class})
@ImportResource("classpath*:*3.xml")
public class AppConfig {
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonValidator personValidator= (PersonValidator)context.getBean("personValidalidator");
        Person person = new Person();
        System.out.println(personValidator.validate(person));
        personValidator.validate(person).forEach(objectError ->
        {
            System.out.println(objectError.getCode()+":" + objectError.getDefaultMessage());
        });
        //对象包装
        Company company  = (Company)BeanWrapperUtil. wrapperCompany(new Company());
        //格式化对象
        CustomerDate customerDate =  (CustomerDate)context.getBean("customerDate");
        System.out.println(customerDate);

        //通过工具类直接转换
        ConversionService conversionService =  (ConversionService)context.getBean("conversionService");
        int result = conversionService.convert("15",Integer.class);
        System.out.println(result);
    }

}

package cap1.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 1.用于修改配置文件内容
 * 2.在jdbc初始化对象前可以修改ip  或者其他配置信息的内容
 * 3.在  资源文件读取之后  bean 创建之前执行
 *4.初始化的时候调用
 * 5. 容易造成所有 有该属性的 对象的值 都变为一样
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("myService");
        MutablePropertyValues pv =  bd.getPropertyValues();
        System.out.println("MyBeanFactoryPostProcessor===>>>" +pv );
        pv.getPropertyValueList().forEach(obj->
        {
            System.out.println(obj.getName() +"<<<===>>>"+obj.getValue().toString() );
        });
        if (pv.contains("name"))
        {
            pv.addPropertyValue("name", "name 被改过了 呵呵!!");
        }
        bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }
}

package cap1.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 1.先创建一个继承 BeanPostProcessor
 * 2.注册到容器中即可
 * 3.执行 postProcessBeforeInitialization 和 postProcessAfterInitialization 方法
 * BeanPostProcessor的基本使用 当bean 被创建后 执行
 * 4.context.getBean 的时候调用
 */

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationTracingBeanPostProcessor_postProcessBeforeInitialization：" + beanName + "' created : " + bean.toString());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationTracingBeanPostProcessor_postProcessBeforeInitialization：" + beanName + "' created : " + bean.toString());
        return bean;
    }
}

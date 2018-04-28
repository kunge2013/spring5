package cap5.java.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * Cglib 代理
 */
public class CglibHomeLink implements MethodInterceptor {
    private Object targetObject;
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("开始执行");
        lazy();
        Object result = methodProxy.invoke(targetObject, objects);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }
    public Object getProxyObject(Object object) {
               this.targetObject = object;
              //增强器，动态代码生成器
               Enhancer enhancer=new Enhancer();
                 //回调方法
                enhancer.setCallback(this);
               //设置生成类的父类类型
                enhancer.setSuperclass(targetObject.getClass());
                //动态生成字节码并返回代理对象
                return enhancer.create();
           }
    // 模拟延时
     public void lazy()
     {
                try
                {
                     int n = (int) new Random().nextInt(500);
                       Thread.sleep(n);
                 } catch (InterruptedException e)
                {
                       e.printStackTrace();
                }
     }
}

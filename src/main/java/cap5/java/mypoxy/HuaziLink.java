package cap5.java.mypoxy;

import cap5.java.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HuaziLink implements  MyInvocationHandler {
    private Person target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是链家，我帮别人找房子..");
        method.invoke(target, args);
        System.out.println("我是链家，已经找完了..");
        return null;
    }

    public Object getInstance(Person target){
        this.target = target;
        Class clazz = target.getClass();

        MyClassLoader load  = new MyClassLoader();
        Object obj = OwnerPoxy.newProxyInstance(load,clazz.getInterfaces(),this);
        return obj;
    }
}

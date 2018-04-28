package cap5.java.mypoxy;

import java.lang.reflect.Method;

public interface  MyInvocationHandler {
    //接口的方法invoke
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}

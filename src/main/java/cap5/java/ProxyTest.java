package cap5.java;

import cap5.java.cglib.CglibHomeLink;
import cap5.java.jdkDynamicpoxy.HomeLink;
import cap5.java.mypoxy.HuaziLink;
import cap5.java.staticpoxy.LiuDeHuaProxy;

public class ProxyTest {
    public static void main(String[] args) {
        //静态代理
//        LiuDeHuaProxy proxy = new LiuDeHuaProxy();
//        Person p = proxy.getProxy();
//        String retValue = p.sing("冰雨");
//        System.out.println(retValue);
//        String value = p.dance("江南style");
//        System.out.println(value);
        //动态代理
//        Person person = (Person) new HomeLink().getInstance(new LianjiaObj());
//        person.sing("链家");

//        Person ldh = (Person) new HomeLink().getInstance(new LiuDeHua());
//        ldh.sing("刘德华");
//        ownerPoxy();
        //cglib 代理实现
         LiuDeHua person = (LiuDeHua)  new CglibHomeLink().getProxyObject(new LiuDeHua());
         person.sing("喜欢你");
         Object str = (Object)  new CglibHomeLink().getProxyObject(new Object());
         System.out.println(str);
    }

    //手写自己的代理
    public static void ownerPoxy(){
        Person person = (Person) new HuaziLink().getInstance(new LiuDeHua());
        System.out.println(person);
        person.sing("刘德华唱冰雨了");
    }
}

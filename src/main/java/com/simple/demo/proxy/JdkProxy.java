package com.simple.demo.proxy;

import javax.security.auth.Subject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Title:com.simple.demo.proxy.JdkProxy
 * @Auther: Charles Rao
 * @Date: 2020/05/19/20:41
 * @Description:
 */
public class JdkProxy implements InvocationHandler {

    private  Object object;

    public JdkProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object object1, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行之前");
        System.out.println(object1.toString());
        Object invoke = method.invoke(object, args);
        System.out.println("方法执行之后");
        return invoke;
    }
    public Object getNewInstance(){
        ClassLoader loader = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader,interfaces,this);
    }

}

package com.simple.demo.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Title:com.simple.demo.proxy.CglibMethodIntercepor
 * @Auther: Charles Rao
 * @Date: 2020/05/19/20:48
 * @Description:
 */
public class CglibMethodInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("目标方法执行之前");
        Object o = methodProxy.invokeSuper(obj, args);
        System.out.println("目标方法执行之后");
        return o;
    }
}

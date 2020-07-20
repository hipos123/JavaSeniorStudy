package com.yaoxj.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: yaoxj
 * @create: 2020-07-10 16:47
 **/
public class JdkCacheHandler implements InvocationHandler {

    private Object target;

    public JdkCacheHandler(Object target){
        this.target=target;
    }


    public Object createJdkProxy(){
        Class clazz=target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("查找数据库之前，在缓存中查找是否存在："+args[0]);
        Object result = method.invoke(target, args);
        System.out.printf("查找数据库后，将%s加入到缓存中", result);
        return result;
    }
}

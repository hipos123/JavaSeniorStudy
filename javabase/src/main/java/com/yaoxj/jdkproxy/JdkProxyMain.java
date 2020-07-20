package com.yaoxj.jdkproxy;

/**
 * @description:
 * @author: yaoxj
 * @create: 2020-07-10 16:52
 **/
public class JdkProxyMain {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        UserServiceImpl userService=new UserServiceImpl();
        JdkCacheHandler jdkCacheHandler=new JdkCacheHandler(userService);
        UserService jdkProxy = (UserService) jdkCacheHandler.createJdkProxy();
        String yaoxj = jdkProxy.getUserName("yaoxj");
        System.out.println(jdkProxy.getClass());
    }

}

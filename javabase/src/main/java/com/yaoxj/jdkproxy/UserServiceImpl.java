package com.yaoxj.jdkproxy;

/**
 * @description:
 * @author: yaoxj
 * @create: 2020-07-10 16:42
 **/
public class UserServiceImpl implements UserService{
    @Override
    public String getUserName(String name) {
        System.out.println("从数据库获取到数据："+name);
        return name;
    }
}

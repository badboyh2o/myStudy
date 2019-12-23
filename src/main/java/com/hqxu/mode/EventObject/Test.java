package com.hqxu.mode.EventObject;

public class Test {

    public static void main(String[] args) {

        UserService service = new UserService();

        //1.注册监听器
        service.addListeners(new SendEmailListener());

        //添加其他监听器 ...

        User user = new User("zhangsan", "123456", "zhangsan@huawei.com");

        //2.注册用户
        service.register(user);
    }
}

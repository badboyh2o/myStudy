package com.hqxu.mode.EventObject;

/**
 * 注册用户

 * @author xuhongqiang
 *
 */
public class Test {

    public static void main(String[] args) {

        UserService service = new UserService();

        //注册用户
        UserVO user = new UserVO("zhangsan", "123456", "zhangsan@huawei.com");
        service.register(user);
    }
}

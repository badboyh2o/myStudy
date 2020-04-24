package com.hqxu.mode.EventObject;

/**
 * 模拟触发事件
 * 		先注册监听器 ？？ 每次都要手工注册？
 * 		触发事件
 * 		
 * @author xuhongqiang
 *
 */
public class Test {

    public static void main(String[] args) {

        UserService service = new UserService();

        //1.注册监听器, 
        service.addListeners(new UserRegistListener());

        //2.注册用户
        UserVO user = new UserVO("zhangsan", "123456", "zhangsan@huawei.com");
        service.register(user);
    }
}

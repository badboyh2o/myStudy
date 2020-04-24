package com.hqxu.mode.EventObject;

import java.util.List;


/**
 * 业务类
 * 
 * @author xuhongqiang
 *
 */
public class UserService {

    /**
     * 业务方法
     * 	!! 成功执行方法之后发布一个事件
     */
    public void register(UserVO user){
    	// 模拟注册成功
        System.out.println("success save user " + user.getUsername() + "/" + user.getPassword() + " to database");
        
        
        // ？？ 耦合到代码
        // 用户注册成功后，发布一个事件 
        // 新建一个事件发布器
        UserEventPublisher userEventPublisher = new UserEventPublisher();
        
        
        
        // 1.注册 与用户事件 相关   的监听器 （查询监听器）
        userEventPublisher.addListeners(new UserRegistListener()); // 如果有其他监听器呢??? 应该通过反射，获取所有的监听器，for循环执行监听器方法
        // 2.发布一个用户注册事件
        UserEvent event = new UserRegistEvent(user); // 事件源是 UserVO
        userEventPublisher.publishEvent(event);
    }


}

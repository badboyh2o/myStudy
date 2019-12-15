package com.hqxu.mode.EventObject;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<UserListener> listeneres = new ArrayList<UserListener>();

    /**
     * 当用户注册的时候，触发发送邮件事件
     * @param user
     */
    public void register(User user){
        System.out.println("save " + user.getUsername() + " : " + user.getPassword() + " to database");
        UserEvent event = new UserEvent(user);
        // 触发
        publishEvent(event);

    }

    
    
    /**
     * 处理事件
     * @param event
     */
    public void publishEvent(UserEvent event){
        for(UserListener listener : listeneres){
            listener.onRegister(event);
        }
    }

    
    
    /**
     * 注册监听器
     * @param listener
     */
    public void addListeners(UserListener listener){
        this.listeneres.add(listener);
    }

}

package com.hqxu.mode.EventObject;

import java.util.ArrayList;
import java.util.List;


/**
 * 业务类
 * 
 * 	需要注入监听器  (提供 添加监听器的方法  addListeners)
 *  业务方法执行成功，触发一个事件（执行该事件每一个监听器的指定方法）？？ 耦合到每一个方法？
 * 
 * @author xuhongqiang
 *
 */
public class UserService {

	/**
	 * 注入监听器
	 */
    private List<UserListener> listeneres = new ArrayList<UserListener>();

    /**
     * 注册监听器
     * @param listener
     */
    public void addListeners(UserListener listener){
        this.listeneres.add(listener);
    }
    
    
    /**
     * 业务方法
     * 	成功执行方法之后发布一个事件
     */
    public void register(UserVO user){
        System.out.println("save " + user.getUsername() + " : " + user.getPassword() + " to database");
        
        UserEvent event = new UserEvent(user);
        publishEvent(event);
    }

    
    /**
     * 触发事件
     * 	执行每一个监听器的方法
     * @param event
     */
    public void publishEvent(UserEvent event){
        for(UserListener listener : listeneres){
            listener.onRegister(event);
        }
    }

}

package com.hqxu.mode.EventObject;

import java.util.ArrayList;
import java.util.List;


/**
 * 事件发布器
 * 		发布用户事件，并使用用户事件监听器
 * 
 * @author xuhongqiang
 *
 */
public class UserEventPublisher {

	/**
	 * 用户事件监听器列表
	 */
    private List<UserListener> listeneres = new ArrayList<UserListener>();

    /**
     * 注册 用户事件监听器
     * 
     * @param listener
     */
    public void addListeners(UserListener listener){
        this.listeneres.add(listener);
    }
    
    
    /**
     * 发布一个用户事件
     * 		监听器开始工作
     * 
     * @param event
     */
    public void publishEvent(UserEvent event){
    	// 获取监听该事件UserEvent的 所有监听器
    	
    	// 执行监听器的方法
        for(UserListener listener : listeneres){
            listener.onRegister(event);
        }
    }

}

package com.hqxu.mode.EventObject;

import java.util.EventListener;

/**
 * 事件监听器接口
 * 	监听用户注册
 * @author xuhongqiang
 *
 */
public interface UserListener extends EventListener{

    public void onRegister(UserEvent event);

}
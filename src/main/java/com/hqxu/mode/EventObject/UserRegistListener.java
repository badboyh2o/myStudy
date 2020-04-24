package com.hqxu.mode.EventObject;

/**
 * 具体的一个事件监听器
 * 	用户注册的监听器
 * 
 * @author xuhongqiang
 *
 */
public class UserRegistListener implements UserListener {

    @Override
    public void onRegister(UserEvent event) {
        if (event instanceof UserRegistEvent) {
            Object source = event.getSource();
            UserVO user = (UserVO) source;
            System.out.println("send email to " + user.getEmail());
        }
    }
}

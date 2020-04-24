package com.hqxu.mode.EventObject;
/**
 * 具体的事件对象
 * 	发送邮件的事件对象
 * 	
 * @author xuhongqiang
 *
 */
public class UserRegistEvent extends UserEvent {

    private static final long serialVersionUID = 1L;

    public UserRegistEvent(Object source) {
        super(source);
    }
}
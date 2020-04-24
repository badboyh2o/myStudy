package com.hqxu.mode.EventObject;

import java.util.EventObject;

/**
 * 
 * 事件对象 基类
 * 	封装了事件源(即任何具有 行为 的Java 对象)
 * @author xuhongqiang
 *
 */
public class UserEvent extends EventObject {

    private static final long serialVersionUID = 1L;

    public UserEvent(Object source) {
        super(source);
    }

}

package com.hqxu.mode.EventObject;

import java.util.EventObject;

public class UserEvent extends EventObject {

    private static final long serialVersionUID = 1L;

    public UserEvent(Object source) {
        super(source);
    }

}

package com.hqxu.mode.EventObject;

import java.util.EventListener;

public interface UserListener extends EventListener{

    public void onRegister(UserEvent event);

}
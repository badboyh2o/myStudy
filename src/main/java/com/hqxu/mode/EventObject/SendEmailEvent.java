package com.hqxu.mode.EventObject;

public class SendEmailEvent extends UserEvent {

    private static final long serialVersionUID = 1L;

    public SendEmailEvent(Object source) {
        super(source);
    }
}
package com.hqxu.mode.EventObject;

public class SendEmailListener implements UserListener {

    @Override
    public void onRegister(UserEvent event) {
        if (event instanceof SendEmailEvent) {
            Object source = event.getSource();
            User user = (User) source;
            System.out.println("send email to " + user.getEmail());
        }
    }
}

package com.api.product.core.validation;

import java.util.List;

public class NotificationImp implements Notification{

    private List<NoticaficationMessage> notifications;

    public NotificationImp(List<NoticaficationMessage> notifications){
        this.notifications = notifications;
    }

    @Override
    public List<NoticaficationMessage> getErrors() {
        return this.notifications;
    }

    @Override
    public boolean hasErrors() {
        return !notifications.isEmpty();
    }

    @Override
    public void addError(String message) {
        this.notifications.add(new NoticaficationMessage(message));
    }

    @Override
    public void addErrors(List<String> messages) {
        messages.forEach(message -> this.addError(message));
    }


}

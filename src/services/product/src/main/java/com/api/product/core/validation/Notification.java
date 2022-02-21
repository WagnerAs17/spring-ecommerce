package com.api.product.core.validation;

import java.util.List;

public interface Notification {

    boolean hasErrors();
    void addError(String message);
    void addErrors(List<String> messages);
    List<NoticaficationMessage> getErrors();

}

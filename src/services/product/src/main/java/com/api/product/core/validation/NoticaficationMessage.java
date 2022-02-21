package com.api.product.core.validation;

import lombok.Getter;

@Getter
public class NoticaficationMessage {

    private String message;
    public NoticaficationMessage(String message){
        this.message = message;
    }
}

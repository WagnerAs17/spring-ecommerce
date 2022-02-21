package com.api.product.application.controllers;

import com.api.product.application.dtos.ResponseData;
import com.api.product.core.validation.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class MainController {

    @Autowired
    private Notification notification;

    public ResponseEntity customResponse(Object response){
        if(notification.hasErrors())
            return new ResponseEntity(this.notification.getErrors(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity(new ResponseData(response), HttpStatus.CREATED);
    }

    public ResponseEntity customResponse(Object response, HttpStatus statusCode){
        if(notification.hasErrors())
            return new ResponseEntity(this.notification.getErrors(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity(new ResponseData(response), statusCode);
    }


}

package com.spring.demo.learnspring.aop;


import com.spring.demo.learnspring.exception.UnprocessableException;
import com.spring.demo.learnspring.response.MessageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UnprocessableException.class)
    @ResponseBody
    public ResponseEntity handlerexcetion(RuntimeException e) {
        MessageInfo messageInfo =  new MessageInfo();
        messageInfo.setMessage(e.getMessage());
        messageInfo.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(messageInfo);
    }

}

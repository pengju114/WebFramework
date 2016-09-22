/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.exception.handler;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author luzhenwen
 */
@ControllerAdvice("com.pj.web.controller")
public class SpringWebExceptionHandler {
    
    @ExceptionHandler()
    public String webException(Exception exception, HttpServletRequest req){
        req.setAttribute("exception", exception);
        return "web/error";
    }
}

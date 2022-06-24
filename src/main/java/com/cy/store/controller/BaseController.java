package com.cy.store.controller;

import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.ServiceException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * for errors come in controller
 */
public class BaseController {

    public static final int OK = 200;

    @ExceptionHandler(ServiceException.class) // to handle errors
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("The name has been registered");
        }else if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("fail to register");
        }
        return result;
    }
}

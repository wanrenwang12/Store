package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.controller.ex.*;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * for errors come in controller
 */
public class BaseController {

    public static final int OK = 200;

    @ExceptionHandler({ServiceException.class, FileUploadException.class}) // to handle errors
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("The name has been registered");
        }else if (e instanceof UserNotFoundException){
            result.setState(4001);
            result.setMessage("User not exist");
        }else if (e instanceof PasswordNotMatchException){
            result.setState(4002);
            result.setMessage("Password is not correct");
        } else if (e instanceof AddressCountLimitException){
            result.setState(4003);
            result.setMessage("Address Count Limit");
        } else if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("fail to register");
        }else if (e instanceof UpdateException){
            result.setState(5003);
            result.setMessage("Fail to update");
        }else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }
        return result;
    }

    /**
     * get uid from session
     * @param session
     * @return uid
     */
    protected final Integer getuidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * get username from session
     * @param session
     * @return String
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}

package com.cy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return True means continue, False means intercept
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception{
        //get session from request
        Object obj = request.getSession().getAttribute("uid");
        if (obj == null){ //redirect to login
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }
}

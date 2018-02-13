package com.findeng.conf;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.findeng.util.ReturnUtil;

/**
 * 全局异常处理
 */
@ControllerAdvice
@RestController
public class GlobalDefaultExceptionHandler {

    protected Logger log = Logger.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String formatErrorHandler(Exception e, HttpServletResponse response) throws Exception {
        e.printStackTrace();
        if (e instanceof BindException) {
            return ReturnUtil.retParam(1002).toString();
        } else if (e instanceof NullPointerException) {
            return ReturnUtil.retParam(1003).toString();
        } else if (e instanceof ClassCastException) {
            return ReturnUtil.retParam(1005).toString();
        }
        return ReturnUtil.retParam(1004).toString();
    }
}
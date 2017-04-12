package com.pixel.basic.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.pixel.basic.exception.ErrorInfo;
import com.pixel.basic.exception.SystemException;


/**
 *捕获全局异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = SystemException.class)
    public String systemExceptionHandler(Model model, HttpServletRequest req, SystemException e) {
        ErrorInfo<String> er = new ErrorInfo<>();
        er.setCode(ErrorInfo.ERROR);
        er.setMessage(e.getMessage());
        er.setUrl(req.getRequestURL().toString());
        er.setParams(req.getQueryString());
        er.setDatas("发生系统异常，无法继续进行！");
        model.addAttribute("errorInfo", er);
//        e.printStackTrace();
        return "admin/basic/errors/system";
    }

    @ExceptionHandler(value = Exception.class)
    public String defaultExceptionHandler(Model model, HttpServletRequest req, Exception e) {
        ErrorInfo<String> er = new ErrorInfo<>();
        er.setCode(ErrorInfo.ERROR);
        er.setMessage(e.getMessage());
        er.setUrl(req.getRequestURL().toString());
        er.setParams(req.getQueryString());
        er.setDatas("发生异常，无法继续进行！");
        model.addAttribute("errorInfo", er);
//        e.printStackTrace();
        return "admin/basic/errors/default";
    }
}

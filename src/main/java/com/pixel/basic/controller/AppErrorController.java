package com.pixel.basic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  出现异常
 */
@Controller
public class AppErrorController {

    @RequestMapping(value = "404")
    public String error404(Model model, HttpServletRequest request) {
        return "admin/basic/errors/404";
    }

    @RequestMapping(value = "400")
    public String error400(Model model, HttpServletRequest request) {
        return "admin/basic/errors/400";
    }

    @RequestMapping(value = "500")
    public String error500(Model model, HttpServletRequest request) {
        return "admin/basic/errors/500";
    }
}

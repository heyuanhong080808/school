package com.pixel.basic.controller;



import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pixel.basic.annotations.Token;
import com.pixel.basic.model.AppConfig;
import com.pixel.basic.model.User;
import com.pixel.basic.service.AppConfigService;
import com.pixel.basic.service.UserService;
import com.pixel.basic.service.UserServiceImpl;
import com.pixel.basic.tools.TokenTools;

//系统初始化Controller
@Controller  //定义一个控制器
@RequestMapping   //指明相应路径
public class InitController {
	@Autowired  //  注入,自动装配的工作
	private AppConfigService appConfigService;
	@Autowired 
	private UserService userService;
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	


    /** 初始化GET */
    @RequestMapping(value="init", method=RequestMethod.GET)
    @Token(flag= Token.READY)
    public String init(Model model, HttpServletRequest request) {
        AppConfig appConfig = appConfigService.loadOne();
        if(appConfig==null || appConfig.getInitFlag()==null || "0".equals(appConfig.getInitFlag())) {
            //表示可以初始化
            User user = new User();
            user.setStatus(1);
            model.addAttribute("user", user);
            model.addAttribute("initFlag", true);
        } else {
            //表示不可以初始化
            model.addAttribute("initFlag", false);
        }
        return "admin/basic/init";
    }

    /** 初始化POST */
    @Token(flag=Token.CHECK)
    @RequestMapping(value="init", method=RequestMethod.POST)
    public String init(Model model, User user, HttpServletRequest request) {
        if(TokenTools.isNoRepeat(request)) {
            AppConfig appConfig = appConfigService.loadOne();
            if(appConfig==null || appConfig.getInitFlag()==null || "0".equals(appConfig.getInitFlag())) {
                userServiceImpl.initBaseUser(user);
            } else {
                //表示不可以初始化，不可以初始化，则直接返回
            }
        }
        return "redirect:/init";
    }

    /** 系统首页 */
    @RequestMapping(value={"index"}, method=RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        AppConfig appConfig = appConfigService.loadOne();
        if(appConfig==null || appConfig.getInitFlag()==null || "0".equals(appConfig.getInitFlag())) {
            //表示可以初始化
            return "redirect:/init";
        } else {
            //表示不可以初始化，不可以初始化，则直接返回
            String indexPage = appConfig.getIndexPage();
            if(indexPage==null) {indexPage = "/admin";}
            return "redirect:"+indexPage;
        }
    }
}

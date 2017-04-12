package com.pixel.basic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pixel.basic.annotations.AdminAuth;
import com.pixel.basic.model.AppConfig;
import com.pixel.basic.service.AppConfigService;
import com.pixel.basic.service.AppConfigServiceImpl;


//系统配置

@Controller
@RequestMapping(value="admin/appConfig")
//管理员授权验证（@AdminAuth是从basic.annotations.AdminAuth这个类继承过来的）
//@AdminAuth 为后台管理的Annotation(注解)对象
             //Menu实体类 rderNum 序号  //pentity 父节点是否是实体，1：是；其他：否，如果不是实体则需要检测是否存在，不存在则添加 
@AdminAuth(name="系统配置", orderNum=10, psn="系统管理", pentity=0, porderNum=20)
public class AppConfigController {
	@Autowired
	private AppConfigService appConfigService;
	@Autowired
	private AppConfigServiceImpl appConfigServiceImpl;
	                            //Menu实体类    
	@AdminAuth(name="系统配置", orderNum=1, icon="glyphicon glyphicon-cog", type="1")	
	
	
	@RequestMapping(value="index",method=RequestMethod.GET)//get请求
	public String index(Model model,HttpServletRequest request){
	//往前台视图传参数
	model.addAttribute("appConfig",appConfigService.loadOne());//程序启动后第一个启动的方法
	return"admin/basic/appConfig/index";
}

	@RequestMapping(value="index", method=RequestMethod.POST)//post请求
	public String index(Model model,AppConfig appConfig,HttpServletRequest request){
		appConfigServiceImpl.addOrUpdate(appConfig);//添加或跟新
		request.getSession().setAttribute("appConfig", appConfig); //修改后需要修改一次Session中的值
		        //redirect:重定向翻index这个页面
		return "redirect:/admin/appConfig/index";
		
	}

}

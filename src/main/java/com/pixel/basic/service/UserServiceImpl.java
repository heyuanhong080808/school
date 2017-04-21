package com.pixel.basic.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pixel.basic.model.AppConfig;
import com.pixel.basic.model.Menu;
import com.pixel.basic.model.Role;
import com.pixel.basic.model.User;
import com.pixel.basic.tools.AuthTools;
import com.pixel.basic.tools.SecurityUtil;





@Component   //基本注解, 标识了一个受 Spring 管理的组件
public class UserServiceImpl {

@Autowired
private UserService userService;

@Autowired 
private MenuService menuService;

@Autowired
private RoleService roleService;

@Autowired
private AppConfigService appConfigService;

@Autowired
private UserRoleServiceImpl userRoleServiceImpl;

@Autowired
private RoleMenuServiceImpl roleMenuServiceImpl;

@Autowired
private AuthTools authTools;


/**
 * 初始化基础用户数据
 * - 1、初始化菜单
 * - 2、初始化角色
 * - 3、为角色分配所有菜单
 * - 4、添加用户
 * - 5、为用户分配角色
 * @param user
 */
public void initBaseUser(User user){//建立配置系统菜单
	
		try {
			
			authTools.buildSystemMenu("com/pixel/basic/controller/*Controller.class");
			Role role =new Role();
			role.setName("超级管理员");
			role.setSn("ROLE_SUPER_ADMIN");
			roleService.save(role);
			//查询菜单的所有(或所有路径)
			List<Menu> menulist=menuService.findAll();
			for(Menu m:menulist){//循环遍历
				roleMenuServiceImpl.addOrDelete(role.getId(), m.getId());
				
			}
			//密码设置需要引入一个工具类（MD5算法）在tools包里面
			user.setPassword(SecurityUtil.md5(user.getUsername(), user.getPassword()));
		   user.setStatus(1);//状态
		   user.setIsAdmin(1);//是否是管理员
		   user.getCreateDate();//当前系统时间
		   userService.save(user);//保存修改设置
		   //添加或删除用户角色对应关系，如果存在则删除，不存在则添加
		   userRoleServiceImpl.addOrDelete(user.getId(), role.getId());
		   AppConfig ac =appConfigService.loadOne();//系统配置,程序启动后第一个启动的方法
		   SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式的设置
		   if(ac==null){
			   ac=new AppConfig();
			   ac.setCreateDate(sdf.format(new Date()));//系统时间格式设置
			   ac.setAppVersion("V3.0");
			   ac.setAppName("系统名称");
			   ac.setIndexPage("/");//首页路径（地址）
			   ac.setAdminEmail("759297493@qq.com");//管理员邮箱
			   ac.setInitFlag("1");//初始化标记，如果为空或为0，表示都可以初始化
			   appConfigService.save(ac);//保存设置 
		   }else{
			   //如果ac不为空，那么保存当前时间和 设置初始化标记为1 ，不在初始化
			   ac.setCreateDate(sdf.format(new Date()));
			   ac.setInitFlag("1");
			   appConfigService.save(ac);
		   }
		   
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
}






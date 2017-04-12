package com.pixel.basic.dto;

import java.util.Date;
import java.util.List;

import com.pixel.basic.model.User;


/**
 * 登陆令牌对象DTO
 * 
 *
 */           //认证令牌
public class AuthToken {
/*
 * 项目中登陆信息一般存放在session中，因为session是存放在服务器，而cookie存放在客户端，相对cookie、session会更安全。
           另外一个问题，存放进session中的最好是把包括账号、密码的一个类一起存放进去，这样有利于到时候客户修改密码之类的操作
 * */
	//登陆放在Session中的名称
	public static final String SESSION_NAME = "LOGIN_USER";
	
	//登陆用户
	private User user;
	
	//用户权限范围内的菜单

	                     //菜单认证
	private List<MenuDto> authMenu;
	
	//用户权限范围内的sn列表
	                       //sn列表 认证
	private List<String> authList;

	//登录时间 
	private Date login_time;
	
	//登录IP 
	private String login_ip;

	public List<String> getAuthList() {
		return authList;
	}

	public void setAuthList(List<String> authList) {
		this.authList = authList;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<MenuDto> getAuthMenu() {
		return authMenu;
	}

	public void setAuthMenu(List<MenuDto> authMenu) {
		this.authMenu = authMenu;
	}

	public Date getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
}



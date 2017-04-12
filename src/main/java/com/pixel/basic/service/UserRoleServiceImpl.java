package com.pixel.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pixel.basic.model.UserRole;

//@Component被用在要被自动扫描和装配的类上。Spring 注解@Component等效于@Service,@Controller、

@Component
public class UserRoleServiceImpl {
	@Autowired  //自动装配 注入UserRoleService接口里，将自动在代码上下文中找到和其匹配（默认是类型匹配）的Bean，并自动注入到相应的地方去。
	private UserRoleService userRoleService;
	/* 
	 * 添加或删除用户角色对应关系，如果存在则删除，不存在则添加
	 * @param userId 用户id
	 * @param roleId角色id*/
	
	public void addOrDelete(Integer userId ,Integer roleId){
		                             //通过角色id和用户id来查找来获取用户角色
		UserRole ur= userRoleService.findByRidAndUid(userId, roleId);
		//如果不存在则添加，存在则删除
		if(ur==null){
			ur =new UserRole();
			ur.setRid(roleId);
			ur.setUid(userId);
			userRoleService.save(ur);	
		}else{
			userRoleService.delete(ur);
		}	
	}
	
	
	
	

}

package com.pixel.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pixel.basic.model.RoleMenu;

//@Component被用在要被自动扫描和装配的类上。Spring 注解@Component等效于@Service,@Controller、
@Component
public class RoleMenuServiceImpl {
	@Autowired
	private RoleMenuService roleMenuService;
	/* 
	 * 添加或删除对象，如果存在则删除，如果不存在则添加
	 * @param roleId 角色Id
	 * @param menuId 菜单id*/
	
	public void addOrDelete(Integer roleId,Integer menuId){
		                              //查角色id和菜单id
		RoleMenu rm = roleMenuService.queryByRidAndMid(roleId,menuId);//实现接口中的方法
		//添加或删除对象，如果存在则删除，如果不存在则添加
		if (rm ==null){
		rm= new RoleMenu();
			rm.setMid(menuId);
			rm.setRid(roleId);
			roleMenuService.save(rm);
		}else {
			roleMenuService.delete(rm);
		}	
			
	}
	

}

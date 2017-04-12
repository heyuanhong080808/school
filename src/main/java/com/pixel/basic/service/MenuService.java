package com.pixel.basic.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.pixel.basic.model.Menu;

public interface MenuService extends JpaRepository<Menu, Integer>, JpaSpecificationExecutor<Menu> {
	//display,是否显示，0表示不显示，1表示显示. type,菜单类型，1：导航菜单；2：权限菜单 
	//三层嵌套（通过id(mid)（而mid通过RoleMenu的rid来查，（而RoleMenu的id(rid)通过UserRole的（用户表id）uid来匹配）），display=1 and type='1'来查找 menu表）
	 @Query("SELECT m FROM Menu m WHERE m.display=1 AND m.type='1' AND m.id in (SELECT rm.mid FROM RoleMenu rm WHERE rm.rid IN (SELECT ur.rid FROM UserRole ur where ur.uid=?1))")
  //获取菜单里所有用户的id
 List<Menu> findByUser(Integer userId);

	//菜单的唯一英文标识(英文名)来获取用户
	Menu findBySn(String sn);
	
/* 三层嵌套
 * （通过m.id（而（菜单id）m.id通过rolemenu表的rid（角色id）来查询）而rid（角色id）通过UserRole表的uid来匹配查询 和m.display=1查询Menu表的sn（英文名字））
 */
 @Query("SELECT m.sn FROM Menu m WHERE m.display=1 AND m.id in (SELECT rm.mid FROM RoleMenu rm WHERE rm.rid IN (SELECT ur.rid FROM UserRole ur where ur.uid=?1))")
//通过用户的id来查
List<String>listAuthByUser(Integer userId);

//查询菜单表当href不等于空和href不空和href不为#时
 @Query("FROM Menu m WHERE m.href is not null AND m.href!='' AND m.href!='#' ")
//查询菜单的所有路径
List<Menu>listAllUrlMenu();





	
	
	
	

}

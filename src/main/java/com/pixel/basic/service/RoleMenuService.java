package com.pixel.basic.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pixel.basic.model.Role;
import com.pixel.basic.model.RoleMenu;

public interface RoleMenuService extends JpaRepository<RoleMenu, Integer>, JpaSpecificationExecutor<Role> {
//动态查询角色菜单表的id
@Query("SELECT rm.mid FROM RoleMenu rm WHERE rm.rid=:roleId")
//在参数传中参数前加注释@Param并指定名称，在@Query中使用:名称的方式来传递参数
//动态通过角色id来查询菜单id 根据角色的id获取对应的所有菜单id
List<Integer>queryMenuIds(@Param("roleId") Integer roleId);
//通过角色菜单的角色id和菜单id查询
RoleMenu queryByRidAndMid(Integer rid, Integer mid);
	

}

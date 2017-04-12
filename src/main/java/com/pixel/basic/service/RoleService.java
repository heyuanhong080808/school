package com.pixel.basic.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.pixel.basic.model.Role;

public interface RoleService extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {
	//在角色菜单表中通过角色id来查菜单的id
	 @Query("SELECT rm.mid FROM RoleMenu rm WHERE rm.rid=?1")
//获取所有角色所有组的id（根据角色的id获取对应的所有菜单id）
 List<Integer> listRloeMenuIds(Integer roleId);

}

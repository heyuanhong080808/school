package com.pixel.basic.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pixel.basic.model.UserRole;

public interface UserRoleService extends JpaRepository<UserRole, Integer> {
	
	//通过角色id和用户id来查找来获取用户角色
	UserRole findByRidAndUid(Integer uid,Integer rid);
	
	//用名称来匹配查询参数 在用户角色表里通过用户id来查找角色id
	
	  @Query("SELECT ur.rid FROM UserRole ur WHERE ur.uid=:userId")
	//在参数传中参数前加注释@Param并指定名称，在@Query中使用:名称的方式来传递参数。
	List<Integer>queryRoleIds(@Param("userId")Integer userId);
	
	
	
	

}

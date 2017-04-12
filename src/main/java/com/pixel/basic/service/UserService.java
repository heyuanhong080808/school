package com.pixel.basic.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.pixel.basic.model.User;

/*要使接口拥有Jpa的功能，只需要将此接口继承JpaRepository接口即可，JpaRespsitory接口有两个泛型，第一个：
指具体的实体对象User，第二个：指实体对象的主键ID的类型Integer。*/
    //筛选功能需要继承于JpaSpecificationExecutor接口
public interface UserService extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{
	
	//通过用户名获取用户,通过名字去查找
	User findByUsername(String usrname);
	 //可以自定义查找即是自己写SQL语句
    //由于有可能重复，通过uid查找有可能返回多条数据，因此要用一个list来装
    //在用户角色表中通过查用户id来查角色的id
	 @Query("SELECT ur.rid FROM UserRole ur WHERE ur.uid=?1")
	//获取用户所有组的id
	List<Integer>listUserRoleIds(Integer userId);
	
	
	
}

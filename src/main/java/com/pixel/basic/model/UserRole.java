package com.pixel.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity//对应数据库表
public class UserRole {//用户角色类 （将用户和角色的id连在一起）
	@Id
	@GeneratedValue //自增长
	private Integer id;
    private Integer uid;//用户表id
    private Integer rid;//角色表id
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
    
    
	

}

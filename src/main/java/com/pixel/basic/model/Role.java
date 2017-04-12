package com.pixel.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity  //对应数据库的表
public class Role {//角色类
	@Id
	@GeneratedValue  //自增长
	private Integer id;  //id
	private String name; //名字(角色的身份是超管还是其他)
	private String sn;//英文名字
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	

	

}

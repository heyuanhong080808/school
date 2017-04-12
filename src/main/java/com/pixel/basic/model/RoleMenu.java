package com.pixel.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoleMenu {//角色菜单类（将角色和菜单的id连在一起 ）
	@Id
	@GeneratedValue
	private  Integer id;
	private  Integer rid;//角色id
	private Integer mid;//菜单id
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	
	
	

}

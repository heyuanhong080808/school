package com.pixel.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Menu {//菜单类
	@Id
	@GeneratedValue
	private Integer id;
	private String name; //(资源名称)菜单的名称，中文显示名称(如系统管理，系统配置权限管，角色授权等)
	private String  sn;//菜单的唯一英文标识，如:（xi_tong_guan_li_）（UserController.roles）等
	private int orderNum;//(序号)菜单的顺序（1.2.3.4.5等）
	private int display;//是否显示，0表示不显示，1表示显示
	private String href;//菜单的链接地址（如/admin/appConfig/index）或（#）
	private Integer pid;//上一级菜单 id（如1.2.3）
	private String pname;//上一级菜单 name
	private String  psn;//父类的sn（quan_xian_guan_li_） （xi_tong_ying_yong_）
	private String  icon;//菜单的图标（如icon-list，glyphicon glyphicon-tags）
	private String type;// 菜单类型，1：导航菜单；2：权限菜单 
	
	
	
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
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPsn() {
		return psn;
	}
	public void setPsn(String psn) {
		this.psn = psn;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}

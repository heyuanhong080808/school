package com.pixel.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppConfig {//系统配置
	@Id
	@GeneratedValue  //自增长
	private Integer id;
	private String  appName; //系统名称
    private String appVersion;//当前版本
    private String createDate;//创建日期
    private String initFlag;//初始化标记，如果为空或为0，表示都可以初始化
    private String  indexPage;//首页路径（地址）
    private String  contant;//页末联系人
    private String  adminEmail;//管理员邮箱
	
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getInitFlag() {
		return initFlag;
	}
	public void setInitFlag(String initFlag) {
		this.initFlag = initFlag;
	}
	public String getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}
	public String getContant() {
		return contant;
	}
	public void setContant(String contant) {
		this.contant = contant;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
    
    
    
    
    
	

}

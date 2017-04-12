package com.pixel.basic.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Service;

import com.pixel.basic.model.AppConfig;

@Service("appConfigService")//将AppConfigService做控制器
public interface AppConfigService extends JpaRepository<AppConfig, Integer> {
	
	@Query("FROM AppConfig ")//查询AppConfig表的信息
	public AppConfig loadOne();//程序启动后第一个启动的方法
}

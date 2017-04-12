package com.pixel.basic.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pixel.basic.model.AppConfig;
import com.pixel.basic.tools.MyBeanUtils;


@Component
public class AppConfigServiceImpl {
 /*
  * Persistence context是由一组受托管的实体对象实例所构成的集合。它受entity manager 的管理。
  * Entity manager追踪persistence context中所有对象的修改和更新情况，并根据指定的flush模式将这些修改保存到数据库中。
  * 一旦persistence context被关闭，所有实体对象实例都会脱离EntityManager而成为非托管对象。
  * 对象一旦从persistence context中脱离，就不再受entity manager管理了，任何对此对象的状态变更也将不会被同步到数据库。
  * */
	
	

	    @PersistenceContext
	    EntityManager em;

	    @Autowired
	    private AppConfigService appConfigService;

	    public void addOrUpdate(AppConfig ac) {
	        AppConfig a = appConfigService.loadOne();
	        if(a==null) {
	            appConfigService.save(ac);
	        } else {
	            MyBeanUtils.copyProperties(ac, a, new String[]{"id"});
	            appConfigService.save(a);
	        }
	    }
}

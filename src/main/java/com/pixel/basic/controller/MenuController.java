package com.pixel.basic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pixel.basic.annotations.AdminAuth;
import com.pixel.basic.annotations.Token;
import com.pixel.basic.model.Menu;
import com.pixel.basic.service.MenuService;
import com.pixel.basic.service.MenuServiceImpl;
import com.pixel.basic.tools.AuthTools;
import com.pixel.basic.tools.TokenTools;
import com.pixel.basic.utils.BaseSearch;
import com.pixel.basic.utils.PageableUtil;
import com.pixel.basic.utils.SearchDto;
import com.pixel.basic.utils.SortDto;

/**
 * 菜单管理Controller
 */
@Controller
@RequestMapping(value="admin/menu")
             //name资源名称,spn父节点SN, orderNum 序号,pentity父节点是否是实体，1：是；其他：否，  porderNum父节点的序号
@AdminAuth(name="菜单管理",psn="权限管理",orderNum=1,pentity=0,porderNum=2)

public class MenuController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuServiceImpl menuServiceImpl;
	@Autowired
	private AuthTools authTools;//权限管理工具,主要用于通过Annotation(注解)自动生成菜单
	
	/* 列表*/
	       //name资源名称,orderNum序号,icon资源图标,类型：type 1为导航菜单 2 为权限菜单.
	@AdminAuth(name="菜单管理",orderNum=1,icon="icon-list",type="1")
	@RequestMapping(value="list",method= RequestMethod.GET)
	public String list(Model model,Integer pid,Integer page,HttpServletRequest request){
		//获取菜单数据，以JSON数据返回.type 菜单类型，1：导航菜单；2：权限菜单；其他：全部
		String treeJson=menuServiceImpl.queryTreeJson("1");
				Page<Menu>datas; //分页（菜单的数据）
		if(pid==null||pid<0){     //根据pid来做分页
			BaseSearch<Menu> spec=new BaseSearch<>(new SearchDto("pid", "isnull", ""));
			datas=menuService.findAll(Specifications.where(spec).and(new BaseSearch<>(new SearchDto("type", "eq", "1"))), PageableUtil.basicPage(page, 15, new SortDto("asc", "orderNum")));		
		}else{
			BaseSearch<Menu>spec=new BaseSearch<>(new SearchDto("pid", "eq", pid));
			datas=menuService.findAll(Specifications.where(spec).and(new BaseSearch<>(new SearchDto("type", "eq", "1"))), PageableUtil.basicPage(page, 15, new SortDto("asc", "orderNum")));		
		}
		model.addAttribute("treeJson",treeJson );
		model.addAttribute("datas", datas);		
		return "admin/basic/menu/list";
		
	}
	
	//重构菜单
	@AdminAuth(name="重构菜单",orderNum=2)
	@RequestMapping(value="rebuildMenus",method=RequestMethod.POST)
	public @ResponseBody String rebuildMenus(Model model,HttpServletRequest request){
	   authTools.buildSystemMenu();//调用authTools.buildSystemMenu()进行重构
		return "1";
		
	}
	
	
	
	//修改菜单 GET方法
	@Token(flag=Token.READY)
	@AdminAuth(name="修改菜单",orderNum=3)
	@RequestMapping(value="update/{id}",method=RequestMethod.GET)
	public String update(Model model,@PathVariable Integer id,HttpServletRequest request){
		Menu m=menuService.findOne(id);//通过id来查找
		model.addAttribute("menu", m);
		return "admin/basic/menu/update";
	}
	
	//修改菜单 POST方法
@Token(flag=Token.CHECK)
@RequestMapping(value="update/{id}",method=RequestMethod.POST)
public String update(Model model,@PathVariable Integer id,Menu menu,HttpServletRequest request){
	if(TokenTools.isNoRepeat(request)){ //不重复
		Menu m =menuService.findOne(id);
       m.setIcon(menu.getIcon());//获取图案
		menuService.save(m);
	}
	return "redirect:/admin/menu/list";
	
}


//菜单排序
@AdminAuth(name="菜单排序",orderNum=4)
@RequestMapping("updateSort")
public @ResponseBody  String updateSort(Integer[]ids){//根据id进行排序
	   try {
           menuServiceImpl.updateSort(ids);
       } catch (Exception e) {
           return "0";
       }
       return "1";
}

}

package com.pixel.basic.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * 后台管理的Annotation(注解)对象
 * 
 * @Retention是java当中的一个元注解，该元注解通常都是用于对软件的测试
 * 
 * @Retention(RetentionPolicy.RUNTIME)
    @interface AdminAuth {.......}

    参数RetentionPolicy.RUNTIME就说明了，@AdminAuth 注解在程序运行时是可见的
    RetentionPolicy的枚举类型还有SOURCE、CLASS分别指定注解对于那个级别是可见的，但是
    我们一般都是用RUNTIME，因为这是在程序运行时可以对注解进行读取，从而易于软件的测试
 *
 */

//RetentionPolicy.RUNTIME 表示运行时保留(注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；)

@Retention(RetentionPolicy.RUNTIME)
public @interface AdminAuth {
	//资源名称
	public String sn() default"";
	//父节点SN
	public  String psn ()default"";
	//资源图标，使用bootstrap
	public String icon() default" glyphicon glyphicon-tags ";
	//是否显示，默认为1显示
	public int display()default 1;//因为dispaly在model层定义为int类型 
	//链接地址  ，默认为#
	public String url()default"#";
	//类型：1为导航菜单 2 为权限菜单.默认为2权限菜单
	public String type() default"2"; 
	//资源名称
	public String name();
	//序号
	public int orderNum();//model层里定义orderNum为int类型
	
	/** 父节点是否是实体，1：是；其他：否，如果不是实体则需要检测是否存在，不存在则添加 */
	public int pentity() default 1;
	//父节点的序号
	public int porderNum()default 1;

}

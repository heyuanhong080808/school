package com.pixel.basic.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.METHOD)//指定该注解只能应用于方法名上
@Retention(RetentionPolicy.RUNTIME)//指定运行时保留
public @interface Token {
	//1：为添加数据前    READY:准备好的
	public static final String READY="1";
	//为添加数据时，需要进行验证
	public static  final String CHECK="2";
	
	//指定验证标记，如果为1，保存防止重复标记；为2,检查是否为重复提交    flag (标记）
	public String flag();
}

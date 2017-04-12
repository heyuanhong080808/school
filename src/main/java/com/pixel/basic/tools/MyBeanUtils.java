package com.pixel.basic.tools;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

import java.util.HashSet;
import java.util.Set;

/**
 * 重写Spring下BeanUtils的copyProperties方法
 *
 *BeanUtils提供对Java反射和自省API的包装。其主要目的是利用反射机制对JavaBean的属性进行处理。我们知道，
 *一个JavaBean通常包含了大量的属性，很多情况下，对JavaBean的处理导致大量get/set代码堆积，增加了代码长
 *度和阅读代码的难度。
 *
 *copyProperties()方法,提供类型转换功能，即发现两个JavaBean的同名属性为不同类型时，在支持的数据类型范围内进行转换
 */
public class MyBeanUtils extends BeanUtils {
	
	public static void copyProperties(Object source, Object target, String [] ignoreFields)
			throws BeansException {
		BeanUtils.copyProperties(source, target, concat(ignoreFields, getNullPropertyNames(source)));
	}

    private static String[] concat(String[] a, String[] b) {
        String[] c= new String[a.length+b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}

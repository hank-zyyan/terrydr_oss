package com.terrydr.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Yan
 * @Description 操作日志
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface OperatorLog {
	int scope();
	//0、添加；1、更新；2、删除（更新）；3、删除；4、其他
	int type() default 4;
	String desc();
}

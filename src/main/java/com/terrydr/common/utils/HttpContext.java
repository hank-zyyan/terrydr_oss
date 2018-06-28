package com.terrydr.common.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
* @Description: spring HTTP上下文
* @return HttpServletRequest
* @author YanZhengYaun
* @date 2018/6/28 17:19
*/
@Component
public class HttpContext {
	public HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
}

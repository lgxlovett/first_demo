package com.lgx.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;


public class ServletContextInit implements ServletContextAware,
		InitializingBean {

	private ServletContext sc;

	public void afterPropertiesSet() throws Exception {
		String path = sc.getContextPath();
		sc.setAttribute("path", path);
	}

	public void setServletContext(ServletContext servletContext) {
		this.sc = servletContext;
	}

}

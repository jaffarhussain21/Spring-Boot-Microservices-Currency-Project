package com.example.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * This method is used to see if you want to execute this filter. There might be
	 * situations when you do not want this filter to get executed.
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Real logic of interception goes here
	 */
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {} ", request, request.getRequestURI());
		return null;
	}

	/**
	 * Filter type is to indicate when this filtering should happen before the
	 * request is executed or after the request is executed or if any error in the
	 * request. Values can be "pre", "post" or "error"
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	/**
	 * If you have multiple filters like logging filter, Security Filter etc then
	 * its sets priority order and return 1, 2 etc priorities.
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub

		return 0;
	}

	
}

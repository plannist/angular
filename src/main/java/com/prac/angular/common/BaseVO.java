package com.prac.angular.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.Data;

@Data
public abstract class BaseVO {
	public Sort sort;
	public int pageSize = 15;
	
	public void setSort(String... orders) {
		this.sort = new Sort(orders);
	}
	
	public PageRequest getPageRequest() {
		return new PageRequest(getPage()-1, getPageSize(), getSort());
	}
	
	public int getPage() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		int page = ServletRequestUtils.getIntParameter(request, "page", 1);
		return page;
	}
}

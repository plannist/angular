package com.prac.angular;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "db")
@Component
public class DataSourceInfo {
	
	private Map<String, String> dataSource;
	
	private Map<String, String> hibernate;

	public Map<String, String> getDataSource() {
		return dataSource;
	}

	public void setDataSource(Map<String, String> dataSource) {
		this.dataSource = dataSource;
	}

	public Map<String, String> getHibernate() {
		return hibernate;
	}

	public void setHibernate(Map<String, String> hibernate) {
		this.hibernate = hibernate;
	}
	
	public String getHiberateVale(String key) {
		return hibernate.get(key);
	}
	
	public String getDataSourceValue(String key) {
		return dataSource.get(key);
	}
	
}

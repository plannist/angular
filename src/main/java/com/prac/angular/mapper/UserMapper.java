package com.prac.angular.mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	List<Map<String, Object>> getUserInfo(Map map);
}

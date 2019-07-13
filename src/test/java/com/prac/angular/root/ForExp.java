package com.prac.angular.root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ForExp {
	@Test
	public void test() {
		Map<String, Object> map = makeMap();
		List<Object> list = (List)map.get("dataSets"); 
		for(int i=0; i<list.size(); i++) {
			System.out.println("list.size: "+i);
			list.get(i);
		}
	}
	
	public Map<String, Object> makeMap() {
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> data = new HashMap<>();
		data.put("1", "일");
		data.put("2", "이");
		data.put("3", "삼");
		data.put("4", "사");
		data.put("5", "오");
		list.add(data);
		data = new HashMap<>();
		data.put("6", "육");
		data.put("7", "칠");
		data.put("8", "팔");
		data.put("9", "구");
		data.put("10", "십");
		List<Map<String, String>> dataList = new ArrayList<>();
		Map<String, String> dataListData = new HashMap<>();
		dataListData.put("11", "십일");
		dataListData.put("12", "십이");
		dataListData.put("13", "십삼");
		dataListData.put("14", "십사");
		dataListData.put("15", "십오");
		dataList.add(dataListData);
		dataListData.put("16", "십육");
		dataListData.put("17", "십칠");
		dataListData.put("18", "십팔");
		dataListData.put("19", "십구");
		dataListData.put("20", "이십");
		dataList.add(dataListData);
		data.put("data", dataListData);
		list.add(data);
		map.put("dataSets", list);
		return map;
	}
	
}

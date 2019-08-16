package com.prac.angular.search;

import lombok.Data;

@Data
public class BuildingSearch {
	private String address;
	private String buildType;
	private int page;
	private String price;
}

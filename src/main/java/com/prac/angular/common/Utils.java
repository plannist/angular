package com.prac.angular.common;

import org.springframework.stereotype.Component;

public final class Utils {
	public static void println(String str) {
		System.out.println("\u001B[31m"+str);
	}
	
	public static Boolean isNullOrEmpty(Object obj) {
		if(obj == null || obj.toString().isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}

package com.prac.angular.common;

import org.springframework.stereotype.Component;

@Component
public final class Utill {
	public void println(String str) {
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

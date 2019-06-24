package com.prac.angular.common;

import org.springframework.stereotype.Component;

@Component
public class Utill {
	public void println(String str) {
		System.out.println("\u001B[31m"+str);
	}
}

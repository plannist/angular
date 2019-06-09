package com.prac.angular;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class OracleConnectionTest {
	
	@Test
	public void test() throws Exception {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@fullhouse.c1d2wea4uxbf.ap-northeast-2.rds.amazonaws.com:1521:JAVA";
		String user = "station4";
		String password = "pjh871107";
		
		Class.forName(driver);
		
		try(Connection con = DriverManager.getConnection(url, user, password)){
			System.out.println("오라클 연결 !!@@");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

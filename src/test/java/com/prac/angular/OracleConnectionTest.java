package com.prac.angular;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConnectionTest {
	
	@Test
	public void test() throws Exception {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@plannist.cn97lepujcj7.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
		String user = "plannist";
		String password = "pjh871107";
		
		Class.forName(driver);
		try(Connection con = DriverManager.getConnection(url, user, password)){
			System.out.println("오라클 연결 !!@@");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

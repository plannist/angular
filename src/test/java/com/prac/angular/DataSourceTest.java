package com.prac.angular;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {DataSourceConfig.class, DataSourceInfo.class})
public class DataSourceTest {
	
	@Test
	public void test() {
		System.out.println("dataSource: ");
	}
	
}

package com.prac.angular;

//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages= {"com.prac.angular.mapper"})
//@PropertySource("classpath:/db.properties")
public class DataSourceConfig {
//	@Autowired
//	Environment evn; //evn 은 @PropertySource 에 등록된 경로 프로퍼티 소스의 데이터를 자동으로 담고있다. 
//	
//	@Value("${jdbc.driver}")
//	private String driverClassName;
//	@Value("${jdbc.url}")
//	private String URL;
//	@Value("${jdbc.user}")
//	private String user;
//	@Value("${jdbc.password}")
//	private String password;
//	
//	@Bean(name="dataSource")
//	public DataSource dataSource() {
//		System.out.println("@@@ db.properties driver: "+driverClassName+", URL: "+URL+", user: "+user+", passwoard: "+password);
//		System.out.println("@@@ db.properties evn driver: "+evn.getProperty("jdbc.driver"));
//		BasicDataSource dataSource = new BasicDataSource(); //pom.xml 이아닌 build path의 library 서버 runtime 톰캣 추가
//		dataSource.setDriverClassName(driverClassName);
//		dataSource.setUrl(URL);
//		dataSource.setUsername(user);
//		dataSource.setPassword(password);
//		return dataSource;
//	}
//	
//	@Bean(name="sqlSessionFactory")
//	public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource")DataSource dataSource) throws Exception{
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/prac/angular/mapper/*.xml"));
////		sessionFactory.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis.xml"));
//		return sessionFactory;
//	}
//	
//	@Bean(name="sqlSessionTemplate")
//	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
	
	

}

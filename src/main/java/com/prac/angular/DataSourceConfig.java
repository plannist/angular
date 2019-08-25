package com.prac.angular;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	@Autowired
	DataSourceInfo dsInfo;
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

///////////////////////////////// 아래 주석 풀면 hibernate sessionFactory 사용 가능 yml 자동 설정이아닌 수동 hibernate 설정임 /////////////////////
//    /**
//     * <pre>
//     * 1. Summary : dataSource bean 을 생성한다.
//     * 2. Details : dataSource bean 을 생성한다.
//     *
//     * 3. LastModifiedDate :
//     * 4. LastReviewedDate :
//     * 5. History
//     * 		2015. 11. 30. writing comments
//     *
//     * </pre>
//     *
//     * @return dataSource instance
//     * @
//     *       @throws
//     *       NamingException
//     * @throws IllegalArgumentException
//     * @throws Exception
//     */
//    @Bean(name = "dataSource")
//    public DataSource dataSourceConfig() 
//    {
//    	
//        BasicDataSource dataSource = new BasicDataSource();
////        dataSource.setDriverClassName(dsInfo.getDataSourceValue("driver-class-name"));
////        dataSource.setUrl(dsInfo.getDataSourceValue("url"));
////        dataSource.setUsername( dsInfo.getDataSourceValue("username"));
////        dataSource.setPassword(dsInfo.getDataSourceValue("password"));
//        
//        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//        dataSource.setUrl("jdbc:oracle:thin:@plannist.cn97lepujcj7.ap-northeast-2.rds.amazonaws.com:1521:ORCL");
//        dataSource.setUsername("plannist");
//        dataSource.setPassword("pjh871107");
//        
//        //System.out.println("========================dsInfo 정보:"+dsInfo.getDataSource());
//        return dataSource;
//        
//    }
//
//
//
//
//
//    /**
//     * <pre>
//     * 1.  Summary : sessionFactory bean 을 생성한다.
//     * 2.  Details : sessionFactory bean 을 생성한다.
//     *
//     * 3. LastModifiedDate :
//     * 4. LastReviewedDate :
//     * 5. History
//     * 		2015. 12. 11. writing comments
//     *
//     * </pre>
//     *
//     * @return
//     * @throws SQLException 
//     * @
//     */
//    @Bean(name = "localSessionFactoryBean")
//    public LocalSessionFactoryBean sessionFactoryBeanConfig()
//    {
////        System.out.println("=============dataSourceInfo: " + dsInfo.getDataSource());
////        System.out.println("=============hibernateInfo: " + dsInfo.getHibernate());
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSourceConfig());
//        // sessionFactoryBean.setPackagesToScan("com.ubivelox.zeus4j.common.domain");
//        sessionFactoryBean.setPackagesToScan("com.prac.angular");
//        Properties hibernateProperties = new Properties();
////        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
////        hibernateProperties.setProperty("hibernate.format_sql", "true");
////        hibernateProperties.setProperty("hibernate.jdbc.batch_size", "0");
////        hibernateProperties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
////        hibernateProperties.setProperty("hibernate.generate_statistics", "true");
////        hibernateProperties.setProperty("hibernate.jdbc.use_streams_for_binary", "true");
////        hibernateProperties.setProperty("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
////        hibernateProperties.setProperty("hibernate.connection.charSet", "UTF-8");
////        hibernateProperties.setProperty("hibernate.validator.apply_to_ddl", "false");
////        hibernateProperties.setProperty("hibernate.validator.autoregister_listeners", "false");
//        
//        
//        {
//
//            for ( Entry<String, String> entry : dsInfo.getHibernate().entrySet() )
//            {
//               
//                hibernateProperties.setProperty(entry.getKey(), entry.getValue());
//            }
//        }
//        sessionFactoryBean.setHibernateProperties(hibernateProperties);
//        return sessionFactoryBean;
//    }
//
//
//
//
//
//    @Bean(name = "sessionFactory")
//    public SessionFactory sessionFactoryConfig()
//    {	
//    	SessionFactory sessionFactory = sessionFactoryBeanConfig().getObject();
//        return sessionFactory;
//    }
//
//
//
//
//
//    @Bean
//    public HibernateTransactionManager jpaTransactionManager() {
//    	System.out.println("=============jpaTransactionManager: 인입");
//    	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactoryConfig());
//        return transactionManager;
//    }
//    
//    @Primary
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//    	System.out.println("=============EntityManagerFactory: 인입");
////      Map<String, String> propertiesHashMap = new HashMap<>();
////      propertiesHashMap.put("hibernate.ejb.naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringNamingStrategy");
//      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//      factory.setJpaVendorAdapter(vendorAdaptor());
//      factory.setDataSource(dataSourceConfig());
//      factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//      factory.setPackagesToScan("com.prac.angular.entity");
//      Properties jpaProperties = new Properties();
//      jpaProperties.setProperty("show-sql", "true");
//      factory.setJpaProperties(jpaProperties);
//      //factory.getJpaPropertyMap().put("hibernate.dialect", TiberoDialect.class.getName());
//      //factory.afterPropertiesSet();
//      return factory;
//    }
//    
//    private HibernateJpaVendorAdapter vendorAdaptor() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setShowSql(true);
//        return vendorAdapter;
//    }

}

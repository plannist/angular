package com.prac.angular;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

//@Configuration
public class JpaConfig {
	
//	@Bean(name="dataSource")
//	@Autowired
//	public DataSource dataSourceConfig(DataBaseInfo databaseInfo) {
//
//		BasicDataSource dataSource = new BasicDataSource();
//		Map<String, String> dsInfo = databaseInfo.getDataSource();
//		dataSource.setDriverClassName(dsInfo.get("driver-class-name"));
//		dataSource.setUrl(dsInfo.get("url"));
//		dataSource.setUsername( dsInfo.get("username"));
//		dataSource.setPassword(dsInfo.get("password"));
//		return dataSource;
//		
//	}
//	
//	@Bean(name="localSessionFactoryBean")
//	@Autowired
//	public LocalSessionFactoryBean sessionFactoryBeanConfig(DataBaseInfo databaseInfo, DataSource dataSource) {
//		System.out.println("=============dataSource: "+dataSource);
//		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource);
//		sessionFactoryBean.setPackagesToScan(new String[] {"com.prac.angular.entity"});
//        Properties hibernateProperties = new Properties();
//        {
//            for ( Entry<String, String> entry : databaseInfo.getHibernate()
//                                                            .entrySet() )
//            {
//              
//            	System.out.println("=============entry: "+entry);
//                hibernateProperties.setProperty(entry.getKey(), entry.getValue());
//            }
//        }
//        sessionFactoryBean.setHibernateProperties(hibernateProperties);
//		
//		
//		return sessionFactoryBean;
//	}
//	
//	@Bean(name="sessionFactory")
//	@Autowired
//	public SessionFactory sessionFactoryConfig(LocalSessionFactoryBean localSessionFactoryBean) {
//		 return localSessionFactoryBean.getObject();
//	}
//	
//    @Bean(name = "transactionManager")
//    @Autowired
//    public HibernateTransactionManager transactionManagerConfig(final SessionFactory sessionFactory)
//    {
//        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
//        hibernateTransactionManager.setSessionFactory(sessionFactory);
//        return hibernateTransactionManager;
//    }
//    
//    @Primary
//    @Bean
//    public EntityManagerFactory entityManagerFactory()
//    {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(false);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.prac.angular.entity");
////        factory.setDataSource(dataSourceConfig);
//        factory.getJpaPropertyMap()
//               .put("hibernate.dialect", org.hibernate.dialect.Oracle10gDialect.class.getName());
//        factory.afterPropertiesSet();
//
//        return factory.getObject();
//    }
	
}

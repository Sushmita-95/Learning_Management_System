package com.springORM.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class ORMConfig {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(getDataSource());
		sessionFactoryBean.setPackagesToScan("com.springORM.entity");
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());
		return sessionFactoryBean;
	}
	
	private DataSource getDataSource() {
		DriverManagerDataSource dataSource = new  DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("M8184586y$");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springorm");	
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");	
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
	}

	
	
	
	
	

}

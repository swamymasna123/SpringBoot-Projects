package com.swamy.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swamy.model.Employee;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.swamy")
public class DbConfig {

	//1.Datasource Properties
	@Autowired
	private DataSource ds;

	//2.LocalSessionFactoryBean Properties

	@Bean
	public LocalSessionFactoryBean sesFact() {
		LocalSessionFactoryBean ses = new LocalSessionFactoryBean();
		ses.setDataSource(ds);
		ses.setAnnotatedClasses(Employee.class);
		ses.setHibernateProperties(props());
		return ses;
	}

	//3.Collection Properties with JPA Keys
	@Bean
	public Properties props() {
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		return props;
	}


	//4.HibernateTemplate Properties
	@Bean
	public HibernateTemplate htObj() {
		return new HibernateTemplate(sesFact().getObject());
	}


	//5.HibernateTemplateTxMgr Properties
	@Bean
	public HibernateTransactionManager hbmTxMgr() {
		return new HibernateTransactionManager(sesFact().getObject());
	}
}


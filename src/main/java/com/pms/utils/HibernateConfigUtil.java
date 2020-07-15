package com.pms.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableAutoConfiguration
public class HibernateConfigUtil {

	//@Autowired
	EntityManagerFactory entityManagerFactory;
	
	//@Bean
	public SessionFactory getSessionFactory() {
		if(entityManagerFactory.unwrap(SessionFactory.class)==null) {
			throw new NullPointerException("Hibernate factory not Available");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
}

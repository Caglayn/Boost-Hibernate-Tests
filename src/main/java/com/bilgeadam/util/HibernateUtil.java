package com.bilgeadam.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.BilgeAdamEntity;
import com.bilgeadam.entity.EticaretEntity;
import com.bilgeadam.entity.StudentEntity;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {
		try {
			Configuration configuration = new Configuration();

			//entity classlarini ekliyoruz
			configuration.addAnnotatedClass(StudentEntity.class);
			configuration.addAnnotatedClass(BilgeAdamEntity.class);
			configuration.addAnnotatedClass(EticaretEntity.class);
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	
}

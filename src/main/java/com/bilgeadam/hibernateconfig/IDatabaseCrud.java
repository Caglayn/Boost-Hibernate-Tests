package com.bilgeadam.hibernateconfig;

import java.util.ArrayList;

import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtil;

public interface IDatabaseCrud <T> {

	public void create(T entity);
	public void delete(T entity);
	public void update(T entity);
	default ArrayList<T> list(){
		return null;
	}
	
	default T find(long id) {
		return null;
	}
	
	default T singleResult(long id) {
		return null;
	}
	
	default Session databaseConnectionHibernate() {
		return HibernateUtil.getSessionfactory().openSession();
	}
}

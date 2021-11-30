package com.bilgeadam.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.util.HibernateUtil;

public class _1_HqlQuery_Select {
	private static final Logger logger = LogManager.getLogger(_1_HqlQuery_Select.class);
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		// hql : hibernata query language
		String hql = "SELECT students FROM StudentEntity AS students";
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		
		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>)typedQuery.getResultList();
		
		studentEntities.stream().forEach(t -> logger.info(t));
		
	}
}

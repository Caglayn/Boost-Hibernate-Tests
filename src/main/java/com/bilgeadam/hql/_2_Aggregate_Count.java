package com.bilgeadam.hql;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtil;

public class _2_Aggregate_Count {
	private static final Logger logger = LogManager.getLogger(_2_Aggregate_Count.class);

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		// hql : hibernata query language
		String hql = "SELECT count(big_data) FROM StudentEntity";
		TypedQuery<Long> typedQuery = session.createQuery(hql, Long.class);

		Long count = typedQuery.getSingleResult();

		logger.info(count);

	}

}

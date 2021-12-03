package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.BilgeAdamEntity;
import com.bilgeadam.hibernateconfig.IDatabaseCrud;

public class BilgeAdamController implements Serializable, IDatabaseCrud<BilgeAdamEntity> {
	private static final long serialVersionUID = 1696780855232401631L;
	private static final Logger logger = LogManager.getLogger(BilgeAdamController.class);

	public static void main(String[] args) {
		logger.trace("trace"); // all<trace<debug<info<warn<error<fatal<off : log4j seviyeleri
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
	}

	@Override
	public void create(BilgeAdamEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity); // create
			session.getTransaction().commit();
			logger.info("Ekleme islemi tamamlandi" + BilgeAdamController.class);
		} catch (Exception e) {
			logger.error("Ekleme aninda hata meydana geldi !!" + BilgeAdamController.class);
			e.printStackTrace();
		}

	}

	@Override
	public void delete(BilgeAdamEntity entity) {
		try {
			BilgeAdamEntity findEntity = find(entity.getId());

			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity); // delete
				session.getTransaction().commit();
				logger.info("Silme islemi tamamlandi" + BilgeAdamController.class);
			}
		} catch (Exception e) {
			logger.error("Silme aninda hata meydana geldi !!" + BilgeAdamController.class);
			e.printStackTrace();
		}
	}

	@Override
	public void update(BilgeAdamEntity entity) {
//		try {
//			BilgeAdamEntity findEntity = find(entity.getStudentId());
//			findEntity.setEmailAddress(entity.getEmailAddress());
//			findEntity.setStudentName(entity.getStudentName());
//			findEntity.setStudentPassword(entity.getStudentPassword());
//			findEntity.setStudentSurname(entity.getStudentSurname());
//
//			Session session = databaseConnectionHibernate();
//			session.getTransaction().begin();
//			session.merge(findEntity); // update
//			session.getTransaction().commit();
//			logger.info("Guncelleme basarili" + BilgeAdamEntity.class);
//
//		} catch (Exception e) {
//			logger.error("Guncelleme aninda hata meydana geldi !!" + BilgeAdamController.class);
//			e.printStackTrace();
//		}

	}

	@Override
	public ArrayList<BilgeAdamEntity> list() {
		Session session = databaseConnectionHibernate();

		// Entity sorgulamasi, java class ina gore cagirilacak
		String hql = "select bilgeAdamEntity from bilgeAdamEntity as bilgeAdamEntity where bilgeAdamEntity.id>=:key";

		TypedQuery<BilgeAdamEntity> typedQuery = session.createQuery(hql, BilgeAdamEntity.class);

		long id = 1L;
		typedQuery.setParameter("key", id);

		ArrayList<BilgeAdamEntity> arrayList = (ArrayList<BilgeAdamEntity>) typedQuery.getResultList();
		logger.info("listelendi"  + BilgeAdamEntity.class);
		return arrayList;
	}

	@Override
	public BilgeAdamEntity find(long id) {
		Session session = databaseConnectionHibernate();
		BilgeAdamEntity bilgeAdamEntity;

		try {
			bilgeAdamEntity = session.find(BilgeAdamEntity.class, id);

			if (bilgeAdamEntity != null) {
				logger.info("bulundu.." + bilgeAdamEntity);
				return bilgeAdamEntity;
			} else {
				logger.info("Aradiginiz kriterde sonuc bulunamadi..");
			}
		} catch (Exception e) {
			logger.error("Arama sirasinda hata meydana geldi !!" + BilgeAdamController.class);
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public BilgeAdamEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}

}

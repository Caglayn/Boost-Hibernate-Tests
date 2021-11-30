package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.hibernateconfig.IDatabaseCrud;

public class StudentController implements Serializable, IDatabaseCrud<StudentEntity> {
	private static final long serialVersionUID = 3815337198977713489L;
	private static final Logger logger = LogManager.getLogger(StudentController.class);

	public static void main(String[] args) {
		logger.trace("trace"); // all<trace<debug<info<warn<error<fatal<off : log4j seviyeleri
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
	}

	@Override
	public void create(StudentEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity); // create
			session.getTransaction().commit();
			logger.info("Ekleme islemi tamamlandi" + StudentController.class);
		} catch (Exception e) {
			logger.error("Ekleme aninda hata meydana geldi !!" + StudentController.class);
			e.printStackTrace();
		}

	}

	@Override
	public void delete(StudentEntity entity) {
		try {
			StudentEntity findEntity = find(entity.getStudentId());

			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity); // delete
				session.getTransaction().commit();
				logger.info("Silme islemi tamamlandi" + StudentController.class);
			}
		} catch (Exception e) {
			logger.error("Silme aninda hata meydana geldi !!" + StudentController.class);
			e.printStackTrace();
		}
	}

	@Override
	public void update(StudentEntity entity) {
		try {
			StudentEntity findEntity = find(entity.getStudentId());
			findEntity.setEmailAddress(entity.getEmailAddress());
			findEntity.setStudentName(entity.getStudentName());
			findEntity.setStudentPassword(entity.getStudentPassword());
			findEntity.setStudentSurname(entity.getStudentSurname());

			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.merge(findEntity); // update
			session.getTransaction().commit();
			logger.info("Guncelleme basarili" + StudentEntity.class);

		} catch (Exception e) {
			logger.error("Guncelleme aninda hata meydana geldi !!" + StudentController.class);
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<StudentEntity> list() {
		Session session = databaseConnectionHibernate();

		// Entity sorgulamasi, java class ina gore cagirilacak
		String hql = "select studentEntity from StudentEntity as studentEntity where studentEntity.id>=:key";

		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);

		long id = 1L;
		typedQuery.setParameter("key", id);

		ArrayList<StudentEntity> arrayList = (ArrayList<StudentEntity>) typedQuery.getResultList();
		logger.info("listelendi"  + StudentEntity.class);
		return arrayList;
	}

	@Override
	public StudentEntity find(long id) {
		Session session = databaseConnectionHibernate();
		StudentEntity studentEntity;

		try {
			studentEntity = session.find(StudentEntity.class, id);

			if (studentEntity != null) {
				logger.info("bulundu.." + studentEntity);
				return studentEntity;
			} else {
				logger.info("Aradiginiz kriterde sonuc bulunamadi..");
			}
		} catch (Exception e) {
			logger.error("Arama sirasinda hata meydana geldi !!" + StudentController.class);
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public StudentEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}

}

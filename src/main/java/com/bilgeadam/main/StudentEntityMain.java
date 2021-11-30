package com.bilgeadam.main;

import com.bilgeadam.controller.StudentController;
import com.bilgeadam.entity.StudentEntity;

public class StudentEntityMain {

	public static void main(String[] args) {

		//create
		for(int i =0;i<10;i++) {
			StudentEntity studentEntity = new StudentEntity("Big data "+i,"Hamit "+i, "Mizrak " + i, "a@a.com"+i,"12345"+i, 100+i);
			StudentController studentController = new StudentController();
			studentController.create(studentEntity);
		}


		// find
//		StudentController controller = new StudentController();
//		long id = 1;
//		controller.find(id);

		//delete
//		StudentController controller = new StudentController();
//		long id = 2L;
//		StudentEntity studentEntity = new StudentEntity();
//		studentEntity.setStudentId(id);
//		controller.delete(studentEntity);
		
		//update
//		StudentController controller = new StudentController();
//		StudentEntity entity = new StudentEntity("Melih","Dumanli", "a@a.com", "111111");
//		entity.setStudentId(1L);
//		controller.update(entity);
		
		
		//list		
//		StudentController controller = new StudentController();
//		controller.list().stream().forEach(System.out::println);
	}

}

package com.bilgeadam.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.bilgeadam.controller.BilgeAdamController;
import com.bilgeadam.entity.BilgeAdamEntity;

public class BilgeAdamMain {

	public static void main(String[] args) throws IOException {
		
		// file upload
		
		// BLOB
		byte[] resimBlob = Files.readAllBytes(Paths.get("a.png"));
		
		BilgeAdamEntity bilgeAdamEntity = new BilgeAdamEntity();
		bilgeAdamEntity.setEmail("asd@asdf.com");
		bilgeAdamEntity.setPassword("sdfsdfsdf");
		bilgeAdamEntity.setBigData(resimBlob);
		
		BilgeAdamController bilgeAdamController = new BilgeAdamController();
		bilgeAdamController.create(bilgeAdamEntity);

	}

}

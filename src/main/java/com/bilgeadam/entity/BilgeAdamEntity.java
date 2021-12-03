package com.bilgeadam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "bilge_adam")
public class BilgeAdamEntity implements Serializable{
	private static final long serialVersionUID = -4149516439705226333L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "email", length = 100, nullable = false, unique = false)
	private String email;
	
	@Column(name="password", updatable = true)
	private String password;
	
	// columnDefinition = "Decimal(6,2) default '5,00'"
	@Column(name = "price")
	private double price;
	
	// BLOB
	@Lob
	@Column(name = "big_data")
	private byte[] bigData;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getBigData() {
		return bigData;
	}

	public void setBigData(byte[] bigData) {
		this.bigData = bigData;
	}

}

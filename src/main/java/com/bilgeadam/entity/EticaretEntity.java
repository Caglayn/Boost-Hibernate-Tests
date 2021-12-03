package com.bilgeadam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "eticaret", indexes = { @Index(columnList = "id", name = "IX_ETICARET_ID") })
public class EticaretEntity implements Serializable {
	private static final long serialVersionUID = 2079060354808548746L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fiyat")
	private double fiyat;
	
	@Column(name="urun_adi")
	private String urunAdi;
	
	@Column(name="rurn_rengi")
	private String urunRengi;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date tarih;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}

	public String getUrunAdi() {
		return urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	public String getUrunRengi() {
		return urunRengi;
	}

	public void setUrunRengi(String urunRengi) {
		this.urunRengi = urunRengi;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
}

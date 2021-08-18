package com.cjc.app.fl.master.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	
	@Column(unique = true)
	private int cid;
	
	private String cemail;
	@Lob
	private byte[] pancard;
	@Lob
	private byte[] adharcard;
	@Lob
	private byte[] incomeproof;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] addressproof;
	@Lob
	private byte[] vehiclequatation;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] itrfile;
	
}

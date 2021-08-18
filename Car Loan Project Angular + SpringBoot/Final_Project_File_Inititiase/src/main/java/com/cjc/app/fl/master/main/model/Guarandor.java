package com.cjc.app.fl.master.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Guarandor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int guarantorid;
	private String name;
	private long mobileno;
	private long adharno;
	private String occupation;
}

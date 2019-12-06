package com.insurancecalculator.terminsurancecalculator.support.daoModel;

import com.insurancecalculator.terminsurancecalculator.support.entities.TermInsurance;

public class DBtermInsurance extends TermInsurance {
	
	private int id;
	private String name;
	private Double perCentOfSumAssured;
	
	public DBtermInsurance()
	{
		super();
		this.id = id;
	}
	
	public DBtermInsurance(int id, String name, Double perCentOfSumAssured)
	{
		super(name, perCentOfSumAssured);
		this.id = id; 
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

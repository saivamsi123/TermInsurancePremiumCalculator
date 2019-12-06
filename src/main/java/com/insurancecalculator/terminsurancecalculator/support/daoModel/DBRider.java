package com.insurancecalculator.terminsurancecalculator.support.daoModel;

import com.insurancecalculator.terminsurancecalculator.support.entities.Rider;

public class DBRider extends Rider {

	private int id;
	
	public DBRider()
	{
		super();
		this.id = id;
	}
	
	
	public DBRider(int id, String name, Double percentOfPremium)
	{
		super(name, percentOfPremium);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}

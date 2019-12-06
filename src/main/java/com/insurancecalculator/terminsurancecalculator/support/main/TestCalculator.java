package com.insurancecalculator.terminsurancecalculator.support.main;

import java.util.List;
import java.util.Scanner;

import com.insurancecalculator.terminsurancecalculator.support.dao.DBRiderDAO;
import com.insurancecalculator.terminsurancecalculator.support.dao.DBTermInsuraceDAO;
import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBRider;
import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBtermInsurance;

public class TestCalculator {
	
	public static void DBRider()
	{
		String option = null, name = null;
		Double percentOfPremium = 0d;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("You want to give input(yes/no): ");
			option = sc.next();
			if(option.equals("yes"))
			{
				System.out.println("Enter the name");
				name = sc.next();
				System.out.println("Enter the percentOfPremium");
				percentOfPremium = sc.nextDouble();
			}
			else
			{
				break;
			}
		}
		
		DBRiderDAO dao = new DBRiderDAO();
		DBRider dbRider = new DBRider();
		dbRider.setName(name);
		dbRider.setPerCentOfPremium(percentOfPremium);
		if(dao.addAllRiders(dbRider))
		{
			System.out.println("Added successfully....");
		}
		List<DBRider> printList = dao.getAllRiders();
		System.out.println("list of Riders");
		for(DBRider dbPrintList : printList)
		{
			System.out.println(dbPrintList.getId()+" "+dbPrintList.getName()+" "+dbPrintList.getPerCentOfPremium());
		}
	}
	public static void DBTermInsurance()
	{
		String option = null, name = null;
		Double percentOfSumAssured = 0d;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("You want to give input(yes/no): ");
			option = sc.next();
			if(option.equals("yes"))
			{
				System.out.println("Enter the name");
				name = sc.next();
				System.out.println("Enter the percentOfSumAssured");
				percentOfSumAssured = sc.nextDouble();
			}
			else
			{
				break;
			}
		}
		DBTermInsuraceDAO termDao = new DBTermInsuraceDAO();
		DBtermInsurance termInsurance = new DBtermInsurance();
		termInsurance.setName(name);
		termInsurance.setPerCentOfSumAssured(percentOfSumAssured);
		if(termDao.addAllTermInsurance(termInsurance))
		{
			System.out.println("Added successfully....");
		}
		List<DBtermInsurance> printList = termDao.getAllTermInsurance();
		System.out.println("list of TermInsurance");
		for(DBtermInsurance dbPrintList : printList)
		{
			System.out.println(dbPrintList.getId()+" "+dbPrintList.getName()+" "+dbPrintList.getPerCentOfSumAssured());
		}
		
	}
	public static void main(String args[])
	{
		DBRider();
		DBTermInsurance();
	}

}

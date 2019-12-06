package com.insurancecalculator.terminsurancecalculator.support.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.insurancecalculator.terminsurancecalculator.support.dao.DBRiderDAO;
import com.insurancecalculator.terminsurancecalculator.support.dao.DBTermInsuraceDAO;
import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBRider;
import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBTermInsurance;
import com.insurancecalculator.terminsurancecalculator.support.dbUtility.DBUtility;

/**
 * @author Allianz3075
 *
 */
public class TestCalculator {

	static DBUtility dbUtility = new DBUtility("jdbc:mysql://localhost:3306/terminsurancecalculator?serverTimezone=UTC",
			"com.mysql.cj.jdbc.Driver", "root", "");

	public static void main(String args[]) {
		menu();
	}

	private static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.DBAddRider\n"
				+ "2.DBAddAllRiders\n"
				+ "3.DBAddTermInsurance\n"
				+ "4.DBAddAllTermInsurance\n"
				+ "5.DBGetRider\n"
				+ "6.DBGetTermInsurance\n"
				+ "7.DBGetAllRiders\n"
				+ "8.DBGetAllTermInsurance\n"
				+ "9.DBUpdateRiderTest\n"
				+ "10.DBUpdateTermInsuranceTest\n");
		System.out.println("Enter the option to select operation");
		int option = sc.nextInt();
		switch(option) {
			case 1:
				DBAddRider();
				break;
			case 2:
				DBAddAllRiders();
				break;
			case 3:
				DBAddTermInsurance();
				break;
			case 4:
				DBAddAllTermInsurance();
				break;
			case 5:
				DBGetRider();
				break;
			case 6:
				DBGetTermInsurance();
				break;
			case 7:
				DBGetAllRiders();
				break;
			case 8:
				DBGetAllTermInsurance();
				break;
			case 9:
				DBUpdateRiderTest();
				break;
			case 10:
				DBUpdateTermInsuranceTest();
				break;
		}
	}

	public static void DBAddRider() {
		String option = null, name = null;
		Double percentOfPremium = 0d;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("You want to give input(yes/no): ");
			option = sc.next();
			if (option.equals("yes")) {
				System.out.println("Enter the name");
				name = sc.next();
				System.out.println("Enter the percentOfPremium");
				percentOfPremium = sc.nextDouble();
				DBRiderDAO dao = new DBRiderDAO(dbUtility);
				DBRider dbRider = new DBRider();
				dbRider.setName(name);
				dbRider.setPerCentOfPremium(percentOfPremium);
				if (dao.addRider(dbRider) > 0) {
					System.out.println("Added successfully....");
				}
			} else {
				menu();
			}
		}
	}
	
	private static void DBAddAllRiders() {
		DBRiderDAO dao = new DBRiderDAO(dbUtility);

		String option = null, name = null;
		Double percentOfPremium = 0d;
		Scanner sc = new Scanner(System.in);
		List<DBRider> rider = new ArrayList<DBRider>();
		while (true) {
			System.out.println("You want to give input(yes/no): ");
			option = sc.next();
			if (option.equals("yes")) {
				DBRider dbRider = new DBRider();
				System.out.println("Enter the name");
				name = sc.next();
				System.out.println("Enter the percentOfPremium");
				percentOfPremium = sc.nextDouble();
				dbRider.setName(name);
				dbRider.setPerCentOfPremium(percentOfPremium);
				rider.add(dbRider);
				if (dao.addAllRiders(rider) != new int[] {}) {
					System.out.println("Added successfully....");
				}
			} else {
				menu();
			}
		}
		
	}

	public static void DBAddTermInsurance() {
		String option = null, name = null;
		Double percentOfSumAssured = 0d;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("You want to give input(yes/no): ");
			option = sc.next();
			if (option.equals("yes")) {
				System.out.println("Enter the name");
				name = sc.next();
				System.out.println("Enter the percentOfSumAssured");
				percentOfSumAssured = sc.nextDouble();
				DBTermInsuraceDAO termDao = new DBTermInsuraceDAO(dbUtility);
				DBTermInsurance termInsurance = new DBTermInsurance();
				termInsurance.setName(name);
				termInsurance.setPerCentOfSumAssured(percentOfSumAssured);
				if (termDao.addTermInsurance(termInsurance) > 0) {
					System.out.println("Added successfully....");
				}
			} else {
				menu();
			}
		}
	}
	
	private static void DBAddAllTermInsurance() {
		DBTermInsuraceDAO dao = new DBTermInsuraceDAO(dbUtility);

		String option = null, name = null;
		Double percentOfSumAssured = 0d;
		Scanner sc = new Scanner(System.in);
		List<DBTermInsurance> termInsuranceList = new ArrayList<DBTermInsurance>();
		while (true) {
			System.out.println("You want to give input(yes/no): ");
			option = sc.next();
			if (option.equals("yes")) {
				DBTermInsurance dbTermInsurance = new DBTermInsurance();
				System.out.println("Enter the name");
				name = sc.next();
				System.out.println("Enter the percentOfPremium");
				percentOfSumAssured = sc.nextDouble();
				dbTermInsurance.setName(name);
				dbTermInsurance.setPerCentOfSumAssured(percentOfSumAssured);
				termInsuranceList.add(dbTermInsurance);
				if (dao.addAllTermInsurance(termInsuranceList)!= new int[] {}) {
					System.out.println("Added successfully....");
				}
			} else {
				menu();
			}
		}
		
	}

	private static void DBGetRider() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id that you want to fetch");
		int id = sc.nextInt();
		DBRiderDAO dao = new DBRiderDAO(dbUtility);
		DBRider rider = dao.getRider(id);
		System.out.println(rider.getId() + " " + rider.getName() + " " + rider.getPerCentOfPremium());
	}
	
	private static void DBGetTermInsurance()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id that you want to fetch");
		int id = sc.nextInt();
		DBTermInsuraceDAO dao = new DBTermInsuraceDAO(dbUtility);
		DBTermInsurance termInsurance = dao.getTermInsurance(id);
		System.out.println(termInsurance.getId() + " " + termInsurance.getName() + " " + termInsurance.getPerCentOfSumAssured());
	}
	
	private static void DBGetAllRiders()
	{
		DBRiderDAO dao = new DBRiderDAO(dbUtility);
		List<DBRider> printList = dao.getAllRiders();
		System.out.println("list of Riders");
		for (DBRider dbPrintList : printList) {
			System.out.println(
					dbPrintList.getId() + " " + dbPrintList.getName() + " " + dbPrintList.getPerCentOfPremium());
		}
	}
	
	private static void DBGetAllTermInsurance()
	{
		DBTermInsuraceDAO dao = new DBTermInsuraceDAO(dbUtility);
		List<DBTermInsurance> printList = dao.getAllTermInsurance();
		System.out.println("list of terminsurances");
		for (DBTermInsurance dbPrintList : printList) {
			System.out.println(
					dbPrintList.getId() + " " + dbPrintList.getName() + " " + dbPrintList.getPerCentOfSumAssured());
		}
	}
	
	private static void DBUpdateRiderTest()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name");
		String name = sc.next();
		System.out.println("Enter the percentOfPremium");
		Double percentOfPremium = sc.nextDouble();
		DBRider dbRider = new DBRider();
		dbRider.setName(name);
		dbRider.setPerCentOfPremium(percentOfPremium);
		DBUpdateRider(dbRider);
	}
	
	private static void DBUpdateRider(DBRider dbRider)
	{
		DBRiderDAO dao = new DBRiderDAO(dbUtility);
		dao.updateRider(dbRider);
	}
	
	private static void DBUpdateTermInsuranceTest()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name");
		String name = sc.next();
		System.out.println("Enter the percentOfSumAssured");
		Double percentOfSumAssured = sc.nextDouble();
		DBTermInsurance dbTermInsurance = new DBTermInsurance();
		dbTermInsurance.setName(name);
		dbTermInsurance.setPerCentOfSumAssured(percentOfSumAssured);
		DBUpdateTermInsurance(dbTermInsurance);
	}
	
	private static void DBUpdateTermInsurance(DBTermInsurance dbTermInsurance)
	{
		DBTermInsuraceDAO dao = new DBTermInsuraceDAO(dbUtility);
		dao.updateTermInsurance(dbTermInsurance);
	}

}

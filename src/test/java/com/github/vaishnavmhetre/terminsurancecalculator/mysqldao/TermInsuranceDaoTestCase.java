package com.github.vaishnavmhetre.terminsurancecalculator.mysqldao;

import java.util.ArrayList;
import java.util.List;

import com.insurancecalculator.terminsurancecalculator.support.dao.DBTermInsuraceDAO;
import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBTermInsurance;
import com.insurancecalculator.terminsurancecalculator.support.dbUtility.DBUtility;
import com.insurancecalculator.terminsurancecalculator.support.entities.TermInsurance;

import junit.framework.TestCase;

public class TermInsuranceDaoTestCase extends TestCase {
	
	DBUtility dbUtility;
	DBTermInsuraceDAO termDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		dbUtility = new DBUtility("jdbc:mysql://localhost:3306/terminsurancecalculator?serverTimezone=UTC",
				"com.mysql.cj.jdbc.Driver", "root", "");
		termDao = new DBTermInsuraceDAO(dbUtility);
	}

	public void testAddTermInsurance()
	{
		DBTermInsurance termInsurance = new DBTermInsurance();
		termInsurance.setName("sai");
		termInsurance.setPerCentOfSumAssured(30.0d);
		assertTrue(termDao.addTermInsurance(termInsurance) > 0);
	}
	
	public void testAddAllTermInsurance()
	{
		List<DBTermInsurance> termInsurance = new ArrayList<DBTermInsurance>();
		for(int i=0;i<2;i++)
		{
			DBTermInsurance termInsuranceDb = new DBTermInsurance();
			termInsuranceDb.setName("vamsi");
			termInsuranceDb.setPerCentOfSumAssured(80.0d);
			termInsurance.add(termInsuranceDb);
			assertTrue(termDao.addAllTermInsurance(termInsurance) != new int[] {});
		}
	}
	
	public void testGetTermInsurance()
	{
		DBTermInsurance termInsuranceDb = termDao.getTermInsurance(1);
		assertNotNull(termInsuranceDb);
	}
	
	public void testGetAllTermInsurance()
	{
		List<DBTermInsurance> list = termDao.getAllTermInsurance();
		assertNotNull(list);
	}
	
	public void testUpdateTermInsurance()
	{
		testAddTermInsurance();
		DBTermInsurance dbTermInsurance = termDao.getTermInsurance(1);
		dbTermInsurance.setName("Janu");
		dbTermInsurance.setPerCentOfSumAssured(75.0d);
		assertTrue(termDao.updateTermInsurance(dbTermInsurance) > 0);
	}
}

/**
 * 
 */
package com.github.vaishnavmhetre.terminsurancecalculator.mysqldao;

import java.util.ArrayList;
import java.util.List;

import com.insurancecalculator.terminsurancecalculator.support.dao.DBRiderDAO;
import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBRider;
import com.insurancecalculator.terminsurancecalculator.support.dbUtility.DBUtility;

import junit.framework.TestCase;

/**
 * @author Allianz3075
 *
 */
public class RiderDaoTestCase extends TestCase {

	DBUtility dbUtility;
	DBRiderDAO dbRiderDAO;
//	DBTermInsuraceDAO termDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		dbUtility = new DBUtility("jdbc:mysql://localhost:3306/terminsurancecalculator?serverTimezone=UTC",
				"com.mysql.cj.jdbc.Driver", "root", "");
		dbRiderDAO = new DBRiderDAO(dbUtility);
//		termDao = new DBTermInsuraceDAO(dbUtility);
	}

	public void testAddRider() {
		DBRider dbRider = new DBRider();
		dbRider.setName("sai");
		dbRider.setPerCentOfPremium(13.4d);
		assertTrue(dbRiderDAO.addRider(dbRider) > 0);
	}

	public void testAddAllRiders() {
		List<DBRider> list = new ArrayList<DBRider>();
		for (int i = 0; i < 4; i++) {
			DBRider dbRider = new DBRider();
			dbRider.setName("sai");
			dbRider.setPerCentOfPremium(32.0d);
			list.add(dbRider);
			assertTrue(dbRiderDAO.addAllRiders(list) != new int[] {});
		}

	}
//	
//	public void testAddTermInsurance()
//	{
//		DBTermInsurance termInsurance = new DBTermInsurance();
//		termInsurance.setName("vamsi");
//		termInsurance.setPerCentOfSumAssured(10.0d);
//		assertTrue(termDao.addTermInsurance(termInsurance) > 0);
//	}
//	
//	public void testAddAllTermInsurance()
//	{
//		List<DBTermInsurance> termInsuranceList = new ArrayList<DBTermInsurance>();
//		for(int i=0;i<2;i++)
//		{
//			DBTermInsurance termInsurance1 = new DBTermInsurance();
//			termInsurance1.setName("vamsi");
//			termInsurance1.setPerCentOfSumAssured(10.0d);
//			termInsuranceList.add(termInsurance1);
//			assertTrue(termDao.addAllTermInsurance(termInsuranceList) != new int[] {});
//		}
//		
//	}

	public void testGetRider() {
		 
		DBRider rider = dbRiderDAO.getRider(1);
		assertNotNull(rider);
	}

	public void testGetAllRiders() {
		List<DBRider> dbRider = dbRiderDAO.getAllRiders();
		assertNotNull(dbRider);
	}

	public void testUpdateRider() {
		testAddRider();
		DBRider dbRider = dbRiderDAO.getRider(1);
		dbRider.setName("vamsi");
		dbRider.setPerCentOfPremium(90.0d);
		assertTrue(dbRiderDAO.updateRider(dbRider) > 0);

	}
}

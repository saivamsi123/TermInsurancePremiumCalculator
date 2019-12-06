package com.github.vaishnavmhetre.terminsurancecalculator.mysqldao;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(RiderDaoTestCase.class);
		suite.addTestSuite(TermInsuranceDaoTestCase.class);
		//$JUnit-END$
		return suite;
	}

}

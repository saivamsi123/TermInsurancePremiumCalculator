/**
 * 
 */
package com.insurancecalculator.terminsurancecalculator.support.dao.support;

import com.insurancecalculator.terminsurancecalculator.support.dbUtility.DBUtility;

/**
 * @author Allianz3075
 *
 */
public class Dao {
	protected DBUtility dbUtility;

	public Dao(DBUtility dbUtility) {
		setDbUtility(dbUtility);
	}

	/**
	 * @return the dbUtility
	 */
	public DBUtility getDbUtility() {
		return dbUtility;
	}

	/**
	 * @param dbUtility the dbUtility to set
	 */
	public void setDbUtility(DBUtility dbUtility) {
		this.dbUtility = dbUtility;
	}
}

/**
 * 
 */
package com.insurancecalculator.terminsurancecalculator.support.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 * @author Allianz3076
 *
 */
public abstract class TermInsurance {

	protected Double perCentOfSumAssured;
	protected Date endOfTenure;
	protected Date startOfTenure;
	protected String name;
	protected Double sumAssured;
	
	public TermInsurance()
	{
		
	}
	public TermInsurance(String name, Double perCentOfSumAssured)
	{
		this.name = name;
		this.perCentOfSumAssured = perCentOfSumAssured;
	}

	/**
	 * @return the perCentSumAssured
	 */
	public Double getPerCentOfSumAssured() {
		return perCentOfSumAssured;
	}

	/**
	 * @param perCentSumAssured the perCentSumAssured to set
	 */
	public void setPerCentOfSumAssured(Double perCentOfSumAssured) {
		this.perCentOfSumAssured = perCentOfSumAssured;
	}

	/**
	 * @return the endOfTenure
	 */
	public Date getEndOfTenure() {
		return endOfTenure;
	}

	/**
	 * @param endOfTenure the endOfTenure to set
	 */
	public void setEndOfTenure(Date endOfTenure) {
		this.endOfTenure = endOfTenure;
	}

	/**
	 * @param endOfTenure the endOfTenure to set
	 */
	public void setEndOfTenure(Map<String, Integer> endOfTenure) {
		LocalDate temp = LocalDate.now();

		if (endOfTenure.containsKey("years"))
			temp.plusYears(endOfTenure.get("years"));

		if (endOfTenure.containsKey("months"))
			temp.plusMonths(endOfTenure.get("months"));

		this.endOfTenure = java.sql.Date.valueOf(temp);
	}

	/**
	 * @return the startOfTenure
	 */
	public Date getStartOfTenure() {
		return startOfTenure;
	}

	/**
	 * @param startOfTenure the startOfTenure to set
	 */
	public void setStartOfTenure(Date startOfTenure) {
		this.startOfTenure = startOfTenure;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sumAssured
	 */
	public Double getSumAssured() {
		return sumAssured;
	}

	/**
	 * @param sumAssured the sumAssured to set
	 */
	public void setSumAssured(Double sumAssured) {
		this.sumAssured = sumAssured;
	}

	public TermInsurance whereSumAssured(Double sumAssured) {
		setSumAssured(sumAssured);
		return this;
	}

	public TermInsurance wherePerCentOfSumAssured(Double perCentOfSumAssured) {
		setPerCentOfSumAssured(perCentOfSumAssured);
		return this;
	}

	public TermInsurance from(Date startDate) {
		setStartOfTenure(startDate);
		return this;
	}

	public TermInsurance to(Date endDate) {
		setEndOfTenure(endDate);
		return this;
	}

	public Double getPremium() {
		return getSumAssured() * (getPerCentOfSumAssured() / 100);
	}
}

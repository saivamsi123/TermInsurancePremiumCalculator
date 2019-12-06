/**
 * 
 */
package com.insurancecalculator.terminsurancecalculator.support.entities;

/**
 * @author Allianz3076
 *
 */
public abstract class Rider {

	protected Double perCentOfPremium;
	protected String name;
	protected Double premium;

	public Rider()
	{
		
	}
	
	public Rider(String name, Double percentOfPremium)
	{
		this.name = name;
		this.perCentOfPremium = percentOfPremium;
	}
	/**
	 * @return the perCentOfSumAssured
	 */
	public Double getPerCentOfPremium() {
		return perCentOfPremium;
	}

	/**
	 * @param perCentOfPremium the perCentOfSumAssured to set
	 */
	public void setPerCentOfPremium(Double perCentOfPremium) {
		this.perCentOfPremium = perCentOfPremium;
	}

	/**
	 * @return the premium
	 */
	public Double getPremium() {
		return premium;
	}

	/**
	 * @param premium the premium to set
	 */
	public void setPremium(Double premium) {
		this.premium = premium;
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

	public Rider wherePremium(Double premium) {
		setPremium(premium);
		return this;
	}

	public Rider wherePerCentOfPremium(Double perCentOfPremium) {
		setPerCentOfPremium(perCentOfPremium);
		return this;
	}

	public Double getPrice() {
		return premium * (getPerCentOfPremium() / 100);
	}

}

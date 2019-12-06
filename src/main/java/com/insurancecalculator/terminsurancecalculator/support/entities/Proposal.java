/**
 * 
 */
package com.insurancecalculator.terminsurancecalculator.support.entities;

import java.util.Collection;

/**
 * @author Allianz3076
 *
 */
public class Proposal {

	protected TermInsurance insurance;
	protected Collection<Rider> riders;

	/**
	 * @return the insurance
	 */
	public TermInsurance getInsurance() {
		return insurance;
	}

	/**
	 * @param insurance the insurance to set
	 */
	public void setInsurance(TermInsurance insurance) {
		this.insurance = insurance;
	}

	/**
	 * @return the riders
	 */
	public Collection<Rider> getRiders() {
		return riders;
	}

	/**
	 * @param riders the riders to set
	 */
	public void setRiders(Collection<Rider> riders) {
		this.riders = riders;
	}

	public boolean addRider(Rider rider) {
		return riders.add(rider);
	}

	public boolean addRiders(Collection<Rider> riders) {
		return riders.addAll(riders);
	}

	public boolean removeRiders(Collection<Rider> riders) {
		return riders.removeAll(riders);
	}

	public boolean removeRider(Rider rider) {
		return riders.remove(rider);
	}

	public Double getPrice() {
		Double premium = getInsurance().getPremium();
		Double price = premium;

		for (Rider rider : riders)
			price += rider.wherePremium(premium).getPrice();

		return price;
	}
}

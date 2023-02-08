package com.practica2.next.persistence.util;

import java.security.InvalidParameterException;

public class InuputValidation {

	public InuputValidation() {
		throw new IllegalStateException("Utility Class");
	}
	
	public static void parameterValidate(InvestRequest request) {
		
		if(request.equals(null)) {
			throw new InvalidParameterException("InvestRequest cant be null");
		}
		if(request.getAnnualContribution() < 0) {
			throw new InvalidParameterException("Annual Contribution cannot be less than 0");
		}
		if(request.getInitialInvest() < 1000) {
			throw new InvalidParameterException("Initial Invest cannot be less than 1000");
		}
		if(request.getAnnualPercentIncrease() < 0) {
			throw new InvalidParameterException("Annual Percent Increase cannot be less than 0");
		}
		if(request.getYearsInverment() <= 0) {
			throw new InvalidParameterException("Years of Investment must be greater than 0");
		}
		if(request.getInvestmentRerun() <= 0) {
			throw new InvalidParameterException("Investment return must be greater than 0");
		}
	}

	
	
}

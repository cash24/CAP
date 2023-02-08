package com.practica2.next.persistence.util;

import io.swagger.annotations.ApiModelProperty;

public class InvestRequest {
	
	@ApiModelProperty(notes = "Initial Invest", example =  "5000", required = true,
			dataType = "float")
	private float initialInvest;
	@ApiModelProperty(notes = "Annual Contibutions", example = "3000", required = true,
			dataType = "float")
	private float annualContribution;
	@ApiModelProperty(notes = "Annual Percent Increase", example = "1", required = true,
			dataType = "float")
	private float annualPercentIncrease;
	@ApiModelProperty(notes = "Years of Invesment", example = "5",required = true,
			dataType = "float")
	private float yearsInverment;
	@ApiModelProperty(notes = "Invesment Return", example = "5",required = true,
			dataType = "float")
	private float investmentRerun;
	
	public float getInvestmentRerun() {
		return investmentRerun;
	}
	public void setInvestmentRerun(float investmentRerun) {
		this.investmentRerun = investmentRerun;
	}
	public float getInitialInvest() {
		return initialInvest;
	}
	public void setInitialInvest(float initialInvest) {
		this.initialInvest = initialInvest;
	}
	public float getAnnualContribution() {
		return annualContribution;
	}
	public void setAnnualContribution(float annualContribution) {
		this.annualContribution = annualContribution;
	}
	public float getAnnualPercentIncrease() {
		return annualPercentIncrease;
	}
	public void setAnnualPercentIncrease(float annualPercentIncrease) {
		this.annualPercentIncrease = annualPercentIncrease;
	}
	public float getYearsInverment() {
		return yearsInverment;
	}
	public void setYearsInverment(float yearsInverment) {
		this.yearsInverment = yearsInverment;
	}
	
	

}

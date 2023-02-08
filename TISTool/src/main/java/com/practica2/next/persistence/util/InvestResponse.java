package com.practica2.next.persistence.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class InvestResponse {
	
	public InvestResponse() {
		super();
		inverstPerYear = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	private ArrayList<InvestPerYear> inverstPerYear;
	private SummaryInvest summaryInvest;
	private String message;
	
	public ArrayList<InvestPerYear> getInverstPerYear() {
		return inverstPerYear;
	}
	public void setInverstPerYear(ArrayList<InvestPerYear> inverstPerYear) {
		this.inverstPerYear = inverstPerYear;
	}
	public SummaryInvest getSummaryInvest() {
		return summaryInvest;
	}
	public void setSummaryInvest(SummaryInvest summaryInvest) {
		this.summaryInvest = summaryInvest;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}


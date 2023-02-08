package com.practica2.next.service;

import org.springframework.stereotype.Service;

import com.practica2.next.persistence.util.InvestPerYear;
import com.practica2.next.persistence.util.InvestResponse;
import com.practica2.next.persistence.util.InvestRequest;
import com.practica2.next.persistence.util.SummaryInvest;

@Service
public class TisToolInvestorService {

	
	private final InvestResponse response;
	
	public TisToolInvestorService(InvestResponse response) {
		this.response = response;
	}
	
	public InvestResponse InvestCalc(InvestRequest request) {
		
	
		InvestResponse response = new InvestResponse();
		float invest_last = request.getInitialInvest();
		float totalquota = 0; 
		SummaryInvest summary = new SummaryInvest();
		InvestPerYear investPerYearCurrent = null;

		InvestPerYear ipyLast = new InvestPerYear();
		ipyLast.setInitialBalance(request.getInitialInvest());
		ipyLast.setQuota(request.getAnnualContribution());
		ipyLast.setYear(1);
		float revenue = (ipyLast.getInitialBalance() + ipyLast.getQuota()) * (request.getInvestmentRerun() / 100);
		ipyLast.setRevenue(revenue);
		ipyLast.setEndBalance(ipyLast.getInitialBalance() + ipyLast.getQuota() + ipyLast.getRevenue());

		for (int i = 0; i < request.getYearsInverment(); i++) {

			 investPerYearCurrent = new InvestPerYear();
			
			if (i == 0) {
				investPerYearCurrent = ipyLast;
			} else {
				investPerYearCurrent.setInitialBalance(ipyLast.getEndBalance());
				investPerYearCurrent.setQuota(ipyLast.getQuota() * (1+(request.getAnnualPercentIncrease()/100)));
				revenue = (investPerYearCurrent.getInitialBalance() + investPerYearCurrent.getQuota()) * (request.getInvestmentRerun() / 100);
				investPerYearCurrent.setRevenue(revenue);
				investPerYearCurrent.setYear(i+1);
				investPerYearCurrent.setEndBalance(investPerYearCurrent.getInitialBalance() + investPerYearCurrent.getQuota() + investPerYearCurrent.getRevenue());
			}

			response.getInverstPerYear().add(investPerYearCurrent);
			ipyLast = investPerYearCurrent;
			totalquota += investPerYearCurrent.getQuota();
			
		}

		summary.setBalance(investPerYearCurrent.getEndBalance());
		summary.setProfit(investPerYearCurrent.getEndBalance() - request.getInitialInvest() - totalquota);
		
		System.out.println("response:");

		for (InvestPerYear element : response.getInverstPerYear()) {

			System.out.println("A�o: " + element.getYear());
			System.out.println("Saldo inicial: " + element.getInitialBalance());
			System.out.println("SAportacion: " + element.getQuota());
			System.out.println("rendimineito: " + + element.getRevenue());
			System.out.println("saldo final: " + + element.getEndBalance());
			
		}
		
		response.setSummaryInvest(summary);

		return response;
	}
}

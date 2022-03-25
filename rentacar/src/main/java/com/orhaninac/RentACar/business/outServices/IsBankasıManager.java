package com.orhaninac.RentACar.business.outServices;

import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;

public class IsBankasıManager  {
	
	public Result makePayment(int Cvv, String fullName, String cardNo) {
		System.out.println("Payment was made with the ENPARA.");
		return new SuccessResult("Payment was made with the ENPARA.");
	}
}

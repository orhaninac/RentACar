package com.orhaninac.RentACar.business.concretes;

import com.orhaninac.RentACar.business.abstracts.PosAdapterService;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;

public class IsBankasıAdapter  implements PosAdapterService {
	
	@Override
	public Result makePayment(String cardNo,  String cvv, double amount) {
		return new SuccessResult("The payment was made with the ISBANK");
	}

}

package com.orhaninac.RentACar.business.abstracts;

import com.orhaninac.RentACar.core.utilities.results.Result;

public interface PosAdapterService {
	
	Result makePayment(String cardNo, String cvv, double amount);
	
}

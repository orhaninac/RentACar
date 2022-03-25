package com.orhaninac.RentACar.business.abstracts;

import com.orhaninac.RentACar.business.request.CreatePaymentRequest;
import com.orhaninac.RentACar.core.utilities.results.Result;

public interface PosAdapterService {
	
	Result makePayment(CreatePaymentRequest createPaymentRequest);
	
}

package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.ListPaymentDto;
import com.orhaninac.RentACar.business.request.CreatePaymentRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;

public interface PaymentService {
	Result add(CreatePaymentRequest createPaymentRequest);
	Result delete(int id);

	DataResult<List<ListPaymentDto>> getAll();

}

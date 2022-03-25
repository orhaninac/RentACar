package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.ListCreditCardDetailsDto;
import com.orhaninac.RentACar.business.request.CreateCreditCardDetailsRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.exceptions.BusinessException;


public interface CreditCardDetailsService {
	
	DataResult<List<ListCreditCardDetailsDto>> getAll();
	DataResult<ListCreditCardDetailsDto> getById(int id);
	Result create(CreateCreditCardDetailsRequest cardDetailsRequest) throws BusinessException;

}

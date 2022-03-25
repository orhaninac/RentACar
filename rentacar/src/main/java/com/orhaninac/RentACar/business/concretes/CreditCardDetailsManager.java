package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.CreditCardDetailsService;
import com.orhaninac.RentACar.business.dtos.ListCreditCardDetailsDto;
import com.orhaninac.RentACar.business.request.CreateCreditCardDetailsRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.ErrorDataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;
import com.orhaninac.RentACar.dataAccess.abstracts.CreditCardDao;
import com.orhaninac.RentACar.entities.concretes.CreditCardDetails;
import com.orhaninac.RentACar.exceptions.BusinessException;

@Service
public class CreditCardDetailsManager implements CreditCardDetailsService {

	CreditCardDao creditCardDao;
	ModelMapperService modelMapperService;
	
	@Autowired
	public CreditCardDetailsManager(CreditCardDao cardDetailsDao, ModelMapperService mapperService) {
		this.creditCardDao = cardDetailsDao;
		this.modelMapperService = mapperService;
	}

	@Override
	public DataResult<List<ListCreditCardDetailsDto>> getAll() {
		var result = this.creditCardDao.findAll();
		
		List<ListCreditCardDetailsDto> response = result.stream()
				.map(creditCardDetails -> this.modelMapperService.forDto().map(creditCardDetails, ListCreditCardDetailsDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ListCreditCardDetailsDto>>(response);
	}

	@Override
	public DataResult<ListCreditCardDetailsDto> getById(int id) {
		CreditCardDetails result = this.creditCardDao.getById(id);
		
		if(result == null) {
			
			return new ErrorDataResult<ListCreditCardDetailsDto>("Car.NotFound");
		}
		
		ListCreditCardDetailsDto response = this.modelMapperService.forDto().map(result, ListCreditCardDetailsDto.class);
		
		return new SuccessDataResult<ListCreditCardDetailsDto>(response);
	}

	@Override
	public Result create(CreateCreditCardDetailsRequest createCreditCardDetailsRequest) throws BusinessException {
		CreditCardDetails creditCardDetails = this.modelMapperService.forRequest().map(createCreditCardDetailsRequest, CreditCardDetails.class);
		
		this.creditCardDao.save(creditCardDetails);
		
		return new SuccessResult("Credit Card Added.");
	}

}
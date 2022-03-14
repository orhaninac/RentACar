package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.GetIndividualCustomerDto;
import com.orhaninac.RentACar.business.dtos.ListIndividualCustomerDto;
import com.orhaninac.RentACar.business.request.CreateIndividualCustomerRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.exceptions.BusinessException;

public interface IndividualCustomerService {
    DataResult<List<ListIndividualCustomerDto>> getAll();
    Result add(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws BusinessException;
    DataResult<GetIndividualCustomerDto> getById(int id) throws BusinessException;
  //  Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) throws BusinessException;
   // Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) throws BusinessException;
}
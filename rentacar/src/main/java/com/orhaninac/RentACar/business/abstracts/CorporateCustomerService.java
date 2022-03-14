package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.GetCorporateCustomerDto;
import com.orhaninac.RentACar.business.dtos.ListCorporateCustomerDto;
import com.orhaninac.RentACar.business.request.CreateCorporateCustomerRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.exceptions.BusinessException;

public interface CorporateCustomerService {
    DataResult<List<ListCorporateCustomerDto>> getAll();
    Result add(CreateCorporateCustomerRequest createCorporateCustomerRequest) throws BusinessException;
    DataResult<GetCorporateCustomerDto> getById(int id) throws BusinessException;
   // Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest) throws BusinessException;
    //Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) throws BusinessException;
}
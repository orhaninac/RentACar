package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.IndividualCustomerService;
import com.orhaninac.RentACar.business.dtos.GetIndividualCustomerDto;
import com.orhaninac.RentACar.business.dtos.ListIndividualCustomerDto;
import com.orhaninac.RentACar.business.request.CreateIndividualCustomerRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;
import com.orhaninac.RentACar.dataAccess.abstracts.IndividualCustomerDao;
import com.orhaninac.RentACar.entities.concretes.IndividualCustomer;
import com.orhaninac.RentACar.exceptions.BusinessException;

@Service
public class IndividualCustomerManager implements IndividualCustomerService{
	
    IndividualCustomerDao individualCustomerDao;
    ModelMapperService modelMapperService;

    public IndividualCustomerManager(IndividualCustomerDao individualCustomerDao, ModelMapperService modelMapperService) {
        this.individualCustomerDao = individualCustomerDao;
        this.modelMapperService = modelMapperService;
    }

	@Override
	public DataResult<List<ListIndividualCustomerDto>> getAll() {
        
		List<IndividualCustomer> result=this.individualCustomerDao.findAll();
        List<ListIndividualCustomerDto> response = result.stream().map(individualCustomer->this.modelMapperService.forDto().map(individualCustomer,ListIndividualCustomerDto.class)).collect(Collectors.toList());
        
        return new SuccessDataResult<List<ListIndividualCustomerDto>>(response,"Individual Customers Listed Successfully");
	}

	@Override
	public Result add(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws BusinessException {
        
		IndividualCustomer individualCustomer = this.modelMapperService.forRequest().map(createIndividualCustomerRequest,IndividualCustomer.class);
        this.individualCustomerDao.save(individualCustomer);
        
        return new SuccessResult("Individual Customer Added Successfully");
	}

	@Override
	public DataResult<GetIndividualCustomerDto> getById(int id) throws BusinessException {
        
		IndividualCustomer individualCustomer = individualCustomerDao.getById(id);
        GetIndividualCustomerDto individualCustomerDto = this.modelMapperService.forDto().map(individualCustomer,GetIndividualCustomerDto.class);
        
        return new SuccessDataResult<GetIndividualCustomerDto>(individualCustomerDto,"Individual Customer Listed Successfully");
	}

}

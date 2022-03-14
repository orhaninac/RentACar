package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.CorporateCustomerService;
import com.orhaninac.RentACar.business.dtos.GetCorporateCustomerDto;
import com.orhaninac.RentACar.business.dtos.ListCorporateCustomerDto;
import com.orhaninac.RentACar.business.request.CreateCorporateCustomerRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;
import com.orhaninac.RentACar.dataAccess.abstracts.CorporateCustomerDao;
import com.orhaninac.RentACar.entities.concretes.CorporateCustomer;
import com.orhaninac.RentACar.exceptions.BusinessException;

@Service
public class CorporateCustomerManager implements CorporateCustomerService {
    CorporateCustomerDao corporateCustomerDao;
    ModelMapperService modelMapperService;

    @Autowired
    public CorporateCustomerManager(CorporateCustomerDao corporateCustomerDao, ModelMapperService modelMapperService) {
       
    	this.corporateCustomerDao = corporateCustomerDao;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public DataResult<GetCorporateCustomerDto> getById(int id) throws BusinessException {
       
    	CorporateCustomer corporateCustomer = corporateCustomerDao.getById(id);
        GetCorporateCustomerDto corporateCustomerDto = this.modelMapperService.forDto().map(corporateCustomer,GetCorporateCustomerDto.class);
       
        return new SuccessDataResult<GetCorporateCustomerDto>(corporateCustomerDto,"Corporate Customer Listed Successfully");
    }

	@Override
	public DataResult<List<ListCorporateCustomerDto>> getAll() {
		
        List<CorporateCustomer> result=this.corporateCustomerDao.findAll();
        List<ListCorporateCustomerDto> response = result.stream().map(corporateCustomer->this.modelMapperService.forDto().map(corporateCustomer,ListCorporateCustomerDto.class)).collect(Collectors.toList());
       
        return new SuccessDataResult<List<ListCorporateCustomerDto>>(response,"Corporate Customers Listed Successfully");
	}

	@Override
	public Result add(CreateCorporateCustomerRequest createCorporateCustomerRequest) throws BusinessException {
        
		CorporateCustomer corporateCustomer = this.modelMapperService.forRequest().map(createCorporateCustomerRequest,CorporateCustomer.class);
        this.corporateCustomerDao.save(corporateCustomer);
       
        return new SuccessResult("Corporate Customer Added Successfully");
	}



 
}
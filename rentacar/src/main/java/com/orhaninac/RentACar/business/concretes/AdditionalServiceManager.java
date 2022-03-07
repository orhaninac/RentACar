package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.AdditionalServiceService;
import com.orhaninac.RentACar.business.dtos.ListAdditionalServiceDto;
import com.orhaninac.RentACar.business.request.CreateAdditionalServiceRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.dataAccess.abstracts.AdditionalServiceDao;
import com.orhaninac.RentACar.entities.concretes.AdditionalService;

@Service
public class AdditionalServiceManager implements AdditionalServiceService{

	private AdditionalServiceDao additionalServiceDao;
	private ModelMapperService modelMapperService;
	
	
	public AdditionalServiceManager(AdditionalServiceDao additionalServiceDao, ModelMapperService modelMapperService) {
		super();
		this.additionalServiceDao = additionalServiceDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<ListAdditionalServiceDto> getAll() {
		List<AdditionalService> result = additionalServiceDao.findAll();
		List<ListAdditionalServiceDto> response = result.stream()
				.map(additionalService -> modelMapperService.forDto().map(additionalService, ListAdditionalServiceDto.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public void delete(int id) {
		additionalServiceDao.deleteById(id);
		
	}

	@Override
	public void add(CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		AdditionalService additionalService = modelMapperService.forRequest().map(createAdditionalServiceRequest, AdditionalService.class);
		additionalServiceDao.save(additionalService);
		
	}

	@Override
	public ListAdditionalServiceDto getById(int id) {
		AdditionalService additionalService= additionalServiceDao.getById(id);
		ListAdditionalServiceDto response = modelMapperService.forDto().map(additionalService, ListAdditionalServiceDto.class);
		return response;
	}
	


}

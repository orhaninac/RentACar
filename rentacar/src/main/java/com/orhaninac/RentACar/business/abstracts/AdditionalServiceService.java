package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.ListAdditionalServiceDto;
import com.orhaninac.RentACar.business.request.CreateAdditionalServiceRequest;

public interface AdditionalServiceService {
	List<ListAdditionalServiceDto> getAll();
	void delete(int id);
	void add(CreateAdditionalServiceRequest createAdditionalService);
	//Brand update(UpdateBrandRequest updateBrandRequest);

	ListAdditionalServiceDto getById(int id);

}

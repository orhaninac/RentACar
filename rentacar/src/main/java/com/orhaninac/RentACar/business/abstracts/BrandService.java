package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.ListBrandDto;
import com.orhaninac.RentACar.business.request.CreateBrandRequest;
import com.orhaninac.RentACar.business.request.UpdateBrandRequest;


public interface BrandService {

	List<ListBrandDto> getAll();
	void delete(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);

	ListBrandDto getById(int id);

}

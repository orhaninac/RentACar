package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.ListBrandDto;
import com.orhaninac.RentACar.business.request.CreateBrandRequest;


public interface BrandService {

	List<ListBrandDto> getAll();

	void add(CreateBrandRequest createBrandRequest);

	ListBrandDto getById(int id);

}

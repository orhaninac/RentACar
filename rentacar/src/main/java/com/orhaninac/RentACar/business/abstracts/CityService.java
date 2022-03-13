package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.GetCityDto;
import com.orhaninac.RentACar.business.dtos.ListCityDto;
import com.orhaninac.RentACar.business.request.CreateCityRequest;
import com.orhaninac.RentACar.business.request.UpdateCityRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;

public interface CityService {
	DataResult<List<ListCityDto>> getAll();
	Result add(CreateCityRequest createCityRequest);
	DataResult<GetCityDto> getById(int id);
	Result delete(int id);
	Result update(UpdateCityRequest updateCityRequest);
	DataResult<List<ListCityDto>> getByAllId(List<Integer> idList);
}
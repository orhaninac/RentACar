package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.GetCarDamageDto;
import com.orhaninac.RentACar.business.dtos.ListCarDamageDto;
import com.orhaninac.RentACar.business.request.CreateCarDamageRequest;
import com.orhaninac.RentACar.business.request.UpdateCarDamageRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;

public interface CarDamageService {
	DataResult<List<ListCarDamageDto>> getAll();
	Result add(CreateCarDamageRequest createCarDamageRequest);
	DataResult<GetCarDamageDto> getById(int id);
	Result delete(int id);
	Result update(UpdateCarDamageRequest updateCarDamageRequest);
	DataResult<List<ListCarDamageDto>> getByCarId(int carId);

}

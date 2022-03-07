package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.ListCarRentalDto;
import com.orhaninac.RentACar.business.request.CreateCarRentalRequest;
import com.orhaninac.RentACar.business.request.UpdateCarRentalRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;

public interface CarRentalService {

	DataResult<List<ListCarRentalDto>> getAll();

	Result add(CreateCarRentalRequest createCarRentalRequest);

	DataResult<ListCarRentalDto> getById(int id);

	Result delete(int id);

	Result update(UpdateCarRentalRequest updateCarRentalRequest);

	DataResult<List<ListCarRentalDto>> getByCarId(int carId);

}

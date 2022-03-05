package com.orhaninac.RentACar.business.abstracts;

import java.util.List;


import com.orhaninac.RentACar.business.dtos.ListCarMaintenanceDto;
import com.orhaninac.RentACar.business.request.CreateCarMaintenanceRequest;
import com.orhaninac.RentACar.business.request.UpdateCarMaintenanceRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;



public interface CarMaintenanceService {

	DataResult<List<ListCarMaintenanceDto>> getAll();
	Result add(CreateCarMaintenanceRequest createCarMaintenanceRequest);
	DataResult<ListCarMaintenanceDto> getById(int id);
	Result delete(int id);
	Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest);
	DataResult<List<ListCarMaintenanceDto>> getByCarId(int carId);
}
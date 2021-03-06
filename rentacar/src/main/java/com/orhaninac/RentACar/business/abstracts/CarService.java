package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.ListCarDto;
import com.orhaninac.RentACar.business.request.CreateCarRequest;
import com.orhaninac.RentACar.business.request.UpdateCarRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.entities.concretes.Car;



public interface CarService {
	List<ListCarDto> getAll();
	void add(CreateCarRequest createCarRequest);
	ListCarDto getById(int id);
	Car update(UpdateCarRequest updateCarRequest);
	void delete(int id);
	DataResult<List<ListCarDto>> getByDailyPrice(double dailyPrice);
	DataResult<List<ListCarDto>> getAllPaged(int pageNo,int pageSize);
	DataResult<List<ListCarDto>> getAllSorted(String direction);
}

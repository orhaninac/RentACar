package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.ListCarDto;
import com.orhaninac.RentACar.business.request.CreateCarRequest;



public interface CarService {
	List<ListCarDto> getAll();

	void add(CreateCarRequest createCarRequest);
	ListCarDto getById(int id);
	void update (CreateCarRequest createCarRequest);
	void delete(int id);
}

package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.ListColorDto;
import com.orhaninac.RentACar.business.request.CreateColorRequest;
import com.orhaninac.RentACar.business.request.UpdateColorRequest;
import com.orhaninac.RentACar.entities.concretes.Color;


public interface ColorService {

	List<ListColorDto> getAll();
	void delete(int id);
	void add(CreateColorRequest createColorRequest);
	Color update(UpdateColorRequest updateColorRequest);
	ListColorDto getById(int id);
}

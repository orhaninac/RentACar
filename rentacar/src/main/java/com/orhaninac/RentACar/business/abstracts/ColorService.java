package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.ListColorDto;
import com.orhaninac.RentACar.business.request.CreateColorRequest;


public interface ColorService {

	List<ListColorDto> getAll();
	void delete(int id);
	void add(CreateColorRequest createColorRequest);

	ListColorDto getById(int id);
}

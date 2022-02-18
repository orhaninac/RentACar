package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.ColorService;
import com.orhaninac.RentACar.business.dtos.ListColorDto;
import com.orhaninac.RentACar.business.request.CreateColorRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.dataAccess.abstracts.ColorDao;
import com.orhaninac.RentACar.entities.concretes.Color;


@Service
public class ColorManager implements ColorService {

	private ColorDao colorDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<ListColorDto> getAll() {
		List<Color> result = colorDao.findAll();
		List<ListColorDto> response = result.stream()
				.map(color -> modelMapperService.forDto().map(color, ListColorDto.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public void add(CreateColorRequest createColorRequest) {
		Color color = modelMapperService.forRequest().map(createColorRequest, Color.class);
		if (!doesExist(color)) {
			colorDao.save(color);
		}
	}

	@Override
	public ListColorDto getById(int id) {
		Color color = colorDao.getById(id);
		ListColorDto response = modelMapperService.forDto().map(color, ListColorDto.class);
		return response;
	}

	public void delete(int id) {
		colorDao.deleteById(id);
	}
	
	private boolean doesExist(Color color) {
		return Objects.nonNull(colorDao.getByColorName(color.getColorName()));
	}

}

package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.CarService;
import com.orhaninac.RentACar.business.dtos.ListCarDto;
import com.orhaninac.RentACar.business.request.CreateCarRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.dataAccess.abstracts.CarDao;
import com.orhaninac.RentACar.entities.concretes.Car;

@Service
public class CarManager implements CarService {

	private ModelMapperService modelMapperService;
	private CarDao carDao;

	public CarManager(ModelMapperService modelMapperService, CarDao carDao) {
		this.modelMapperService = modelMapperService;
		this.carDao = carDao;
	}

	@Override
	public List<ListCarDto> getAll() {
		List<Car> result = carDao.findAll();
		List<ListCarDto> response = result.stream().map(car -> modelMapperService.forDto().map(car, ListCarDto.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
		carDao.save(car);

	}

	@Override
	public ListCarDto getById(int id) {
		Car car = carDao.getById(id);
		ListCarDto response = modelMapperService.forDto().map(car, ListCarDto.class);
		return response;
	}

	@Override
	public void update(CreateCarRequest createCarRequest) {
		

	}

	@Override
	public void delete(int id) {
		carDao.deleteById(id);
	}

}

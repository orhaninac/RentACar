package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.CarService;
import com.orhaninac.RentACar.business.dtos.ListCarDto;
import com.orhaninac.RentACar.business.request.CreateCarRequest;
import com.orhaninac.RentACar.business.request.UpdateCarRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
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
	public Car update(UpdateCarRequest updateCarRequest) {
		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		carDao.save(car);
		return car;
	}

	@Override
	public void delete(int id) {
		carDao.deleteById(id);
	}

	@Override
	public DataResult<List<ListCarDto>> getByDailyPrice(double dailyPrice) {
		List<Car> result = this.carDao.findByDailyPriceLessThanEqual(dailyPrice);
		List<ListCarDto> response = result.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDto>>(response, "Cars with daily price listed successfully.");
	}

	@Override
	public DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Car> result = this.carDao.findAll(pageable).getContent();
		List<ListCarDto> response = result.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDto>>(response);
	}

	@Override
	public DataResult<List<ListCarDto>> getAllSorted(String direction) {
		Sort sort = Sort.by(Sort.Direction.fromString(direction), "dailyPrice");
		List<Car> result = carDao.findAll(sort);
		List<ListCarDto> response = result.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDto>>(response);
	}




}

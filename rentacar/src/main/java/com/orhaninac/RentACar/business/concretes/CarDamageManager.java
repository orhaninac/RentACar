package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.CarDamageService;
import com.orhaninac.RentACar.business.dtos.GetCarDamageDto;
import com.orhaninac.RentACar.business.dtos.ListCarDamageDto;
import com.orhaninac.RentACar.business.dtos.ListCarMaintenanceDto;
import com.orhaninac.RentACar.business.request.CreateCarDamageRequest;
import com.orhaninac.RentACar.business.request.UpdateCarDamageRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;
import com.orhaninac.RentACar.dataAccess.abstracts.CarDamageDao;
import com.orhaninac.RentACar.dataAccess.abstracts.CarMaintenanceDao;
import com.orhaninac.RentACar.dataAccess.abstracts.CarRentalDao;
import com.orhaninac.RentACar.entities.concretes.CarDamage;
import com.orhaninac.RentACar.entities.concretes.CarMaintenance;

@Service
public class CarDamageManager implements CarDamageService{
	
	private CarDamageDao carDamageDao;
	private ModelMapperService modelMapperService;
	

	public CarDamageManager(CarDamageDao carDamageDao, ModelMapperService modelMapperService) {
		
		super();
		this.carDamageDao = carDamageDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ListCarDamageDto>> getAll() {
		
		List<CarDamage> result = carDamageDao.findAll();
		List<ListCarDamageDto> response = result.stream()
				.map(carDamage -> modelMapperService.forDto().map(carDamage, ListCarDamageDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDamageDto>>(response, "Car damages listed successfully.");
	}

	@Override
	public Result add(CreateCarDamageRequest createCarDamageRequest) {
		
		CarDamage carDamage = this.modelMapperService.forRequest().map(createCarDamageRequest, CarDamage.class);   
		this.carDamageDao.save(carDamage);
		
		return new SuccessResult("Car damege added successfully.");
	}

	@Override
	public DataResult<GetCarDamageDto> getById(int id) {
		
		CarDamage carDamage = carDamageDao.getById(id);
		GetCarDamageDto response = this.modelMapperService.forDto().map(carDamage, GetCarDamageDto.class);
		
		return new SuccessDataResult<GetCarDamageDto>(response, "Getting car damage by id");
	}

	@Override
	public Result delete(int id) {
		
		this.carDamageDao.deleteById(id);
		
		return new SuccessResult("Car damage deleted successfully.");
	}

	@Override
	public Result update(UpdateCarDamageRequest updateCarDamageRequest) {

		CarDamage carDamage = this.modelMapperService.forRequest().map(updateCarDamageRequest, CarDamage.class); this.carDamageDao.save(carDamage);
		
		return new SuccessResult(" ");
	}

	@Override
	public DataResult<List<ListCarDamageDto>> getByCarId(int carId) {
		List<CarDamage> result = this.carDamageDao.findByCar_CarId(carId);
		List<ListCarDamageDto> response = result.stream()
				.map(carDamage -> this.modelMapperService.forDto().map(carDamage, ListCarDamageDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDamageDto>>(response, "Car damages listed successfully.");
	}

}

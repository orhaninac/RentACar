package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.CarMaintenanceService;
import com.orhaninac.RentACar.business.dtos.ListCarMaintenanceDto;
import com.orhaninac.RentACar.business.request.CreateCarMaintenanceRequest;
import com.orhaninac.RentACar.business.request.UpdateCarMaintenanceRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
import com.orhaninac.RentACar.dataAccess.abstracts.CarMaintenanceDao;
import com.orhaninac.RentACar.entities.concretes.CarMaintenance;


@Service
public class CarMaintenanceManager implements CarMaintenanceService {

	private CarMaintenanceDao carMaintenanceDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarMaintenanceManager(CarMaintenanceDao carMaintenanceDao, ModelMapperService modelMapperService) {
		this.carMaintenanceDao = carMaintenanceDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ListCarMaintenanceDto>> getAll() {
		List<CarMaintenance> result = this.carMaintenanceDao.findAll();
		List<ListCarMaintenanceDto> response = result.stream()
				.map(carMaintenance -> this.modelMapperService.forDto().map(carMaintenance, ListCarMaintenanceDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarMaintenanceDto>>(response, "Car maintenances listed successfully.");
	}

	@Override
	public Result add(CreateCarMaintenanceRequest createCarMaintenanceRequest) {
		CarMaintenance carMaintenance = this.modelMapperService.forRequest().map(createCarMaintenanceRequest, CarMaintenance.class);
		carMaintenanceDao.save(carMaintenance);
		return new SuccessResult("Car maintenance added successfully.");
	}

	@Override
	public DataResult<ListCarMaintenanceDto> getById(int id) {
		CarMaintenance carMaintenance = this.carMaintenanceDao.findById(id);
		ListCarMaintenanceDto response = this.modelMapperService.forDto().map(carMaintenance, ListCarMaintenanceDto.class);
		return new SuccessDataResult<ListCarMaintenanceDto>(response, "Getting car maintenance by id");
	}

	@Override
	public Result delete(int id) {
		this.carMaintenanceDao.deleteById(id);
		return new SuccessResult("Car maintenance deleted successfully.");
	}

	@Override
	public Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
		CarMaintenance carMaintenance = this.modelMapperService.forRequest().map(updateCarMaintenanceRequest, CarMaintenance.class);
		carMaintenanceDao.save(carMaintenance);
		return new SuccessResult("Car maintenances updated successfully");
	}

	@Override
	public DataResult<List<ListCarMaintenanceDto>> getByCarId(int carId) {
		List<CarMaintenance> result = this.carMaintenanceDao.findByCar_CarId(carId);
		List<ListCarMaintenanceDto> response = result.stream()
				.map(carMaintenance -> this.modelMapperService.forDto().map(carMaintenance, ListCarMaintenanceDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarMaintenanceDto>>(response, "Car maintenances listed successfully.");
	}



}

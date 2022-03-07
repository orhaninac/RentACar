package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.CarRentalService;
import com.orhaninac.RentACar.business.dtos.ListCarRentalDto;
import com.orhaninac.RentACar.business.request.CreateCarRentalRequest;
import com.orhaninac.RentACar.business.request.UpdateCarRentalRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.ErrorResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;
import com.orhaninac.RentACar.dataAccess.abstracts.CarMaintenanceDao;
import com.orhaninac.RentACar.dataAccess.abstracts.CarRentalDao;
import com.orhaninac.RentACar.entities.concretes.CarMaintenance;
import com.orhaninac.RentACar.entities.concretes.CarRental;

@Service
public class CarRentalManager implements CarRentalService {
	
	private CarRentalDao carRentalDao;
	private ModelMapperService modelMapperService;
	private CarMaintenanceDao carMaintenanceDao;
	


	public CarRentalManager(CarRentalDao carRentalDao, ModelMapperService modelMapperService,
			CarMaintenanceDao carMaintenanceDao) {
		super();
		this.carRentalDao = carRentalDao;
		this.modelMapperService = modelMapperService;
		this.carMaintenanceDao = carMaintenanceDao;
	}

	@Override
	public DataResult<List<ListCarRentalDto>> getAll() {
		List<CarRental> result = carRentalDao.findAll();
		List<ListCarRentalDto> response = result.stream()
				.map(carRental -> modelMapperService.forDto().map(carRental, ListCarRentalDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarRentalDto>>(response, "Car rentals listed successfully.");
	}

	@Override
	public Result add(CreateCarRentalRequest createCarRentalRequest) {
		CarRental carRental = this.modelMapperService.forRequest().map(createCarRentalRequest, CarRental.class);

		if (!checkIsUnderMaintenance(carRental)) {
			return new ErrorResult("CarRental.NotAdded , Car is under maintenance!");
		}
		carRentalDao.save(carRental);
		return new SuccessResult("Car rental added successfully.");
	}

	@Override
	public DataResult<ListCarRentalDto> getById(int id) {
		CarRental carRental = this.carRentalDao.findById(id);
		ListCarRentalDto response = this.modelMapperService.forDto().map(carRental, ListCarRentalDto.class);
		return new SuccessDataResult<ListCarRentalDto>(response, "Getting car maintenance by id");
	}

	@Override
	public Result delete(int id) {
		this.carRentalDao.deleteById(id);
		return new SuccessResult("Car rental deleted successfully.");
	}

	@Override
	public Result update(UpdateCarRentalRequest updateCarRentalRequest) {
		CarRental carRental = this.modelMapperService.forRequest().map(updateCarRentalRequest, CarRental.class);
		carRentalDao.save(carRental);
		return new SuccessResult("Car rental updated successfully");
	}

	@Override
	public DataResult<List<ListCarRentalDto>> getByCarId(int carId) {
		List<CarRental> result = this.carRentalDao.findByCar_CarId(carId);
		List<ListCarRentalDto> response = result.stream()
				.map(carRental -> this.modelMapperService.forDto().map(carRental, ListCarRentalDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarRentalDto>>(response, "Car rental listed successfully.");
	}
	
	private boolean checkIsUnderMaintenance(CarRental carRental) {
		List<CarMaintenance> result = this.carMaintenanceDao.findByCar_CarId(carRental.getCar().getCarId());
		if (result != null) {
			for (CarMaintenance carMaintenance : result) {
				if (carRental.getRentDate().isBefore(carMaintenance.getReturnDate())
						|| carRental.getReturnDate().isBefore(carMaintenance.getReturnDate())) {
					return false;
				}
			}
		}
		return true;
	}

}

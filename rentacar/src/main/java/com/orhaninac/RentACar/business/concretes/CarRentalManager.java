package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.CarMaintenanceService;
import com.orhaninac.RentACar.business.abstracts.CarRentalService;
import com.orhaninac.RentACar.business.abstracts.CarService;
import com.orhaninac.RentACar.business.dtos.ListCarDto;
import com.orhaninac.RentACar.business.dtos.ListCarMaintenanceDto;
import com.orhaninac.RentACar.business.dtos.ListCarRentalDto;
import com.orhaninac.RentACar.business.request.CreateCarRentalRequest;
import com.orhaninac.RentACar.business.request.UpdateCarRentalRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.ErrorDataResult;
import com.orhaninac.RentACar.core.utilities.results.ErrorResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;
import com.orhaninac.RentACar.dataAccess.abstracts.CarMaintenanceDao;
import com.orhaninac.RentACar.dataAccess.abstracts.CarRentalDao;
import com.orhaninac.RentACar.entities.concretes.CarMaintenance;
import com.orhaninac.RentACar.entities.concretes.CarRental;
import com.orhaninac.RentACar.exceptions.BusinessException;

@Service
public class CarRentalManager implements CarRentalService {
	
	private CarRentalDao carRentalDao;
	private ModelMapperService modelMapperService;
	private CarMaintenanceService carMaintenanceService;
	private CarService carService;
	private CarMaintenanceDao carMaintenanceDao;
	

	public CarRentalManager(CarRentalDao carRentalDao, ModelMapperService modelMapperService,
			 CarMaintenanceService carMaintenanceService,CarService carService,CarMaintenanceDao carMaintenanceDao) {
		super();
		this.carRentalDao = carRentalDao;
		this.modelMapperService = modelMapperService;
		this.carMaintenanceService = carMaintenanceService;
		this.carService=carService;
		this.carMaintenanceDao=carMaintenanceDao;
	}

	@Override
	public DataResult<List<ListCarRentalDto>> getAll() {
		List<CarRental> result = carRentalDao.findAll();
		
		if (result.isEmpty()) {
			return new ErrorDataResult<List<ListCarRentalDto>>("There is no rental car.");
		}
		
		List<ListCarRentalDto> response = result.stream()
				.map(carRental -> modelMapperService.forDto().map(carRental, ListCarRentalDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarRentalDto>>(response, "Car rentals listed successfully.");
	}

	@Override
	public Result add(CreateCarRentalRequest createCarRentalRequest) {
		
		checkIfCarIsAvaliable(createCarRentalRequest.getCarId());
		CarRental carRental = this.modelMapperService.forRequest().map(createCarRentalRequest, CarRental.class);
		System.out.println(createCarRentalRequest.getRentDate());
		checkIfInMaintenance(carRental);
		carRentalDao.save(carRental);
		return new SuccessResult("Car rental added successfully.");
	}

	@Override
	public DataResult<ListCarRentalDto> getById(int id) {
		CarRental carRental = this.carRentalDao.findById(id);
		
		if (carRental == null) {
			return new ErrorDataResult<ListCarRentalDto>("No car found with the id");
		}
		
		ListCarRentalDto response = this.modelMapperService.forDto().map(carRental, ListCarRentalDto.class);
		return new SuccessDataResult<ListCarRentalDto>(response, "Getting car maintenance by id");
	}

	@Override
	public Result delete(int id) {
		/checkIfRentalCar(id);
		this.carRentalDao.deleteById(id);
		return new SuccessResult("Car rental deleted successfully.");
	}

	@Override
	public Result update(UpdateCarRentalRequest updateCarRentalRequest) {
		CarRental carRental = this.modelMapperService.forRequest().map(updateCarRentalRequest, CarRental.class);
		checkIfParameterIsNull(updateCarRentalRequest, carRental);
		carRentalDao.save(carRental);
		return new SuccessResult("Car rental updated successfully");
	}

	@Override
	public DataResult<List<ListCarRentalDto>> getByCarId(int carId) {
		List<CarRental> result = this.carRentalDao.findByCar_CarId(carId);
		
		if (result.isEmpty()) {
			return new ErrorDataResult<List<ListCarRentalDto>>("Rental cars could not be listed.");
		}
		
		List<ListCarRentalDto> response = result.stream()
				.map(carRental -> this.modelMapperService.forDto().map(carRental, ListCarRentalDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarRentalDto>>(response, "Car rental listed successfully.");
	}
	

	private void checkIfCarIsAvaliable(int carId) throws BusinessException {

		ListCarDto result = this.carService.getById(carId);

		if (result == null) {
			throw new BusinessException("No car found with this id.");
		}
	}
	
	private void checkIfInMaintenance(CarRental carRental) throws BusinessException {
		//List<ListCarMaintenanceDto> result = this.carMaintenanceService.getByCarId(carRental.getCar().getCarId()).getData();
		List<CarMaintenance> result=carMaintenanceDao.findByCar_CarId(14);
		for (CarMaintenance carMaintenanceDto : result) {
			if ((carMaintenanceDto.getReturnDate() != null)
					&& (carRental.getRentDate().isBefore(carMaintenanceDto.getReturnDate())
							|| carRental.getReturnDate().isBefore(carMaintenanceDto.getReturnDate()))) {
				throw new BusinessException("This car cannot be rented as it is under maintenance");
			}
		}
	}
	
	public boolean checkIfRentalCar(int rentalId) {
		
		if (this.carRentalDao.findById(rentalId) == null) {
			throw new BusinessException("No rental car found with the id");
		}
		
		return true;
	}
	
	private UpdateCarRentalRequest checkIfParameterIsNull(UpdateCarRentalRequest updateRentalCarRequest,
			CarRental rentalCar) {
		
		if (updateRentalCarRequest.getRentDate() == null) {
			updateRentalCarRequest.setReturnDate(rentalCar.getReturnDate());
		}
		
		if (updateRentalCarRequest.getReturnDate() == null) {
			updateRentalCarRequest.setReturnDate(rentalCar.getReturnDate());
		}
		
		return updateRentalCarRequest;
	}


}

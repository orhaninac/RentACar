package com.orhaninac.RentACar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhaninac.RentACar.business.abstracts.CarRentalService;
import com.orhaninac.RentACar.business.dtos.ListCarMaintenanceDto;
import com.orhaninac.RentACar.business.dtos.ListCarRentalDto;
import com.orhaninac.RentACar.business.request.CreateCarRentalRequest;
import com.orhaninac.RentACar.business.request.UpdateCarRentalRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.exceptions.BusinessException;


@RestController
@RequestMapping("/api/carRentals")
public class CarRentalController {
	
	private CarRentalService carRentalService;
	
	@Autowired
	public CarRentalController(CarRentalService carRentalService) {
		this.carRentalService = carRentalService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListCarRentalDto>> getAll() {
		return carRentalService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<ListCarRentalDto> getById(@RequestParam int id) {
		return carRentalService.getById(id);
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateCarRentalRequest createCarRentalRequest) throws BusinessException {
		return this.carRentalService.add(createCarRentalRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody int id)
			throws BusinessException {
		return this.carRentalService.delete(id);
	}

	@PutMapping("/update")
	public Result update(@RequestBody UpdateCarRentalRequest updateCarRentalRequest)
			throws BusinessException {
		return this.carRentalService.update(updateCarRentalRequest);
	}
	
	@GetMapping("/getByCarId/{carId}")
	public DataResult<List<ListCarRentalDto>> getByCarId(@RequestParam int carId) {
		return this.carRentalService.getByCarId(carId);
	}

}

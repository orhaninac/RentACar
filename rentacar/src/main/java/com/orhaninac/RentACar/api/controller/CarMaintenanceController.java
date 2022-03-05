package com.orhaninac.RentACar.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhaninac.RentACar.business.abstracts.CarMaintenanceService;
import com.orhaninac.RentACar.business.dtos.ListCarMaintenanceDto;
import com.orhaninac.RentACar.business.request.CreateCarMaintenanceRequest;
import com.orhaninac.RentACar.business.request.UpdateCarMaintenanceRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/carMaintenances")
public class CarMaintenanceController {
	
	CarMaintenanceService carMaintenanceService;
	
	@Autowired
	public CarMaintenanceController(CarMaintenanceService carMaintenanceService) {
		this.carMaintenanceService = carMaintenanceService;
	}

	@GetMapping("/getAll")
	public DataResult<List<ListCarMaintenanceDto>> getAll() {
		return carMaintenanceService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCarMaintenanceRequest createCarMaintenanceRequest) {
		return carMaintenanceService.add(createCarMaintenanceRequest);
	}

	@GetMapping("/get/{id}")
	public DataResult<ListCarMaintenanceDto> getById(@RequestParam int id) {
		return carMaintenanceService.getById(id);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@RequestParam int id) {
		return carMaintenanceService.delete(id);
	}

	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
		return this.carMaintenanceService.update(updateCarMaintenanceRequest);
	}

	@GetMapping("/getByCarId/{carId}")
	public DataResult<List<ListCarMaintenanceDto>> getByCarId(@RequestParam int carId) {
		return this.carMaintenanceService.getByCarId(carId);
	}
}
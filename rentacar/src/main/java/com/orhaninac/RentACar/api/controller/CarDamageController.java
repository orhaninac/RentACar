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

import com.orhaninac.RentACar.business.abstracts.CarDamageService;
import com.orhaninac.RentACar.business.dtos.GetCarDamageDto;
import com.orhaninac.RentACar.business.dtos.ListCarDamageDto;
import com.orhaninac.RentACar.business.request.CreateCarDamageRequest;
import com.orhaninac.RentACar.business.request.UpdateCarDamageRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/carDamages")
public class CarDamageController {
	
	CarDamageService carDamageService;
	
	@Autowired
	public CarDamageController(CarDamageService carDamageService) {
		this.carDamageService = carDamageService;
	}

	@GetMapping("/getAll")
	public DataResult<List<ListCarDamageDto>> getAll() {
		return carDamageService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCarDamageRequest createCarDamageRequest) {
		return carDamageService.add(createCarDamageRequest);
	}

	@GetMapping("/get/{id}")
	public DataResult<GetCarDamageDto> getById(@RequestParam int id) {
		return carDamageService.getById(id);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@RequestParam int id) {
		return carDamageService.delete(id);
	}

	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateCarDamageRequest updateCarDamageRequest) {
		return this.carDamageService.update(updateCarDamageRequest);
	}

	@GetMapping("/getByCarId/{carId}")
	public DataResult<List<ListCarDamageDto>> getByCarId(@RequestParam int carId) {
		return this.carDamageService.getByCarId(carId);
	}
}
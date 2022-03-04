package com.orhaninac.RentACar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhaninac.RentACar.business.abstracts.CarService;
import com.orhaninac.RentACar.business.dtos.ListCarDto;
import com.orhaninac.RentACar.business.request.CreateCarRequest;
import com.orhaninac.RentACar.business.request.UpdateCarRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/cars")
public class CarController {

	private CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/getall")
	public List<ListCarDto> getAll() {
		return carService.getAll();
	}

	@PostMapping("/save")
	public void add(@RequestBody CreateCarRequest createCarRequest) {
		this.carService.add(createCarRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody int id) {
		this.carService.delete(id);
	}

	@GetMapping("/get")
	public ListCarDto get(@RequestParam int id) {
		return carService.getById(id);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateCarRequest car) {
		this.carService.update(car);
	}
	
	@GetMapping("/getByDailyPrice/{dailyPrice}")
	public DataResult<List<ListCarDto>> getByDailyPrice(@RequestParam double dailyPrice) {
		return this.carService.getByDailyPrice(dailyPrice);
	}
	
	@GetMapping("/getallpages")
	public DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize) {
		return carService.getAllPaged(pageNo, pageSize);
	}

	@GetMapping("/getallsorted")
	public DataResult<List<ListCarDto>> getAllSorted(String direction) {
		return carService.getAllSorted(direction);
	}
}

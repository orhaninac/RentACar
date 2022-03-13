package com.orhaninac.RentACar.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhaninac.RentACar.business.abstracts.CityService;
import com.orhaninac.RentACar.business.dtos.GetCityDto;
import com.orhaninac.RentACar.business.dtos.ListCityDto;
import com.orhaninac.RentACar.business.request.CreateCityRequest;
import com.orhaninac.RentACar.business.request.UpdateCityRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.exceptions.BusinessException;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/cities")
public class CityController {
	
	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListCityDto>> getAll() {
		return cityService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<GetCityDto> get(@RequestParam int id) throws BusinessException {
		return cityService.getById(id);
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCityRequest createCityRequest) throws BusinessException {
		System.out.println(createCityRequest.toString());
		return cityService.add(createCityRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid int id) throws BusinessException {
		return cityService.delete(id);
	}

	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateCityRequest updateCityRequest) throws BusinessException {
		return cityService.update(updateCityRequest);
	}

}
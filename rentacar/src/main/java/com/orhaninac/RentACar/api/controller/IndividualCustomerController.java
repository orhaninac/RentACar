package com.orhaninac.RentACar.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhaninac.RentACar.business.abstracts.IndividualCustomerService;
import com.orhaninac.RentACar.business.dtos.GetIndividualCustomerDto;
import com.orhaninac.RentACar.business.dtos.ListIndividualCustomerDto;
import com.orhaninac.RentACar.business.request.CreateIndividualCustomerRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;


@RestController
@RequestMapping("/api/individualCustomers")
public class IndividualCustomerController {
	private IndividualCustomerService individualCustomerService;

	@Autowired
	public IndividualCustomerController(IndividualCustomerService individualCustomerService) {
		this.individualCustomerService = individualCustomerService;
	}

	@GetMapping("/getAll")
	public DataResult<List<ListIndividualCustomerDto>> getAll() {
		return individualCustomerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		return individualCustomerService.add(createIndividualCustomerRequest);
	}

	@GetMapping("/getById/{id}")
	public DataResult<GetIndividualCustomerDto> getById(@RequestParam int id) {
		return individualCustomerService.getById(id);
	}

}

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

import com.orhaninac.RentACar.business.abstracts.CorporateCustomerService;
import com.orhaninac.RentACar.business.dtos.GetCorporateCustomerDto;
import com.orhaninac.RentACar.business.dtos.ListCorporateCustomerDto;
import com.orhaninac.RentACar.business.request.CreateCorporateCustomerRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;


@RestController
@RequestMapping("/api/corporateCustomers")
public class CorporateCustomerController {
	private CorporateCustomerService corporateCustomerService;

	@Autowired
	public CorporateCustomerController(CorporateCustomerService corporateCustomerService) {
		this.corporateCustomerService = corporateCustomerService;
	}

	@GetMapping("/getAll")
	public DataResult<List<ListCorporateCustomerDto>> getAll() {
		return corporateCustomerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCorporateCustomerRequest createCorporateCustomerRequest) {
		return corporateCustomerService.add(createCorporateCustomerRequest);
	}

	@GetMapping("/getById/{id}")
	public DataResult<GetCorporateCustomerDto> getById(@RequestParam int id) {
		return corporateCustomerService.getById(id);
	}

}

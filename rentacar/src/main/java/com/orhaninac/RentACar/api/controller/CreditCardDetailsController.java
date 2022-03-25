package com.orhaninac.RentACar.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhaninac.RentACar.business.abstracts.CreditCardDetailsService;
import com.orhaninac.RentACar.business.dtos.ListCreditCardDetailsDto;
import com.orhaninac.RentACar.business.request.CreateCreditCardDetailsRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.exceptions.BusinessException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/creditCardDetails")
public class CreditCardDetailsController {
	
	private CreditCardDetailsService creditCardDetailsService;

	@Autowired
	public CreditCardDetailsController(CreditCardDetailsService creditCardDetailsService) {
		this.creditCardDetailsService = creditCardDetailsService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<ListCreditCardDetailsDto>> getAll() {
		return creditCardDetailsService.getAll();
		
	}
	
	@GetMapping("/get")
	DataResult<ListCreditCardDetailsDto> getById(@RequestParam int id) {
		return creditCardDetailsService.getById(id);
		
	}
	
	@PostMapping("/create")
	Result create(@RequestBody CreateCreditCardDetailsRequest cardDetailsRequest) throws BusinessException {
		return creditCardDetailsService.create(cardDetailsRequest);	
	}
	

}

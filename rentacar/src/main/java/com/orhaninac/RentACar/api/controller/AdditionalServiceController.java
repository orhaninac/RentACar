package com.orhaninac.RentACar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orhaninac.RentACar.business.abstracts.AdditionalServiceService;
import com.orhaninac.RentACar.business.dtos.ListAdditionalServiceDto;
import com.orhaninac.RentACar.business.request.CreateAdditionalServiceRequest;

@RestController
@RequestMapping("/api/additionalServices")
public class AdditionalServiceController {
	
	private AdditionalServiceService additionalServiceService ;

	@Autowired
	public AdditionalServiceController(AdditionalServiceService additionalServiceService) {
		this.additionalServiceService = additionalServiceService;
	}

	@GetMapping("/getall")
	public List<ListAdditionalServiceDto> getAll() {
		return additionalServiceService.getAll();
	}

	@PostMapping("/save")
	public void add(@RequestBody CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		this.additionalServiceService.add(createAdditionalServiceRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody int id) {
		this.additionalServiceService.delete(id);
	}

}

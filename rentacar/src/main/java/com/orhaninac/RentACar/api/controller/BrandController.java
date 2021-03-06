package com.orhaninac.RentACar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhaninac.RentACar.business.abstracts.BrandService;
import com.orhaninac.RentACar.business.dtos.ListBrandDto;
import com.orhaninac.RentACar.business.request.CreateBrandRequest;
import com.orhaninac.RentACar.business.request.UpdateBrandRequest;


@RestController
@RequestMapping("/api/brands")
public class BrandController {

	private BrandService brandService;

	@Autowired
	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}

	@GetMapping("/getall")
	public List<ListBrandDto> getAll() {
		return brandService.getAll();
	}

	@PostMapping("/save")
	public void add(@RequestBody CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody int id) {
		this.brandService.delete(id);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateBrandRequest brand) {
		this.brandService.update(brand);
	}

	@GetMapping("/get")
	public ListBrandDto get(@RequestParam int id) {
		return brandService.getById(id);
	}

}

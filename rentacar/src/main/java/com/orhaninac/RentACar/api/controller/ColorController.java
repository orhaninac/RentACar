package com.orhaninac.RentACar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhaninac.RentACar.business.abstracts.ColorService;
import com.orhaninac.RentACar.business.dtos.ListColorDto;
import com.orhaninac.RentACar.business.request.CreateColorRequest;
import com.orhaninac.RentACar.business.request.UpdateColorRequest;


@RestController
@RequestMapping("/api/colors")
public class ColorController {

	private ColorService colorService;

	@Autowired
	public ColorController(ColorService colorService) {
		this.colorService = colorService;
	}

	@GetMapping("/getall")
	public List<ListColorDto> getAll() {
		return colorService.getAll();
	}

	@PostMapping("/save")
	public void add(@RequestBody CreateColorRequest createColorRequest) {
		this.colorService.add(createColorRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody int id) {
		this.colorService.delete(id);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateColorRequest color) {
		this.colorService.update(color);
	}

	@GetMapping("/get")
	public ListColorDto get(@RequestParam int id) {
		return colorService.getById(id);
	}

}

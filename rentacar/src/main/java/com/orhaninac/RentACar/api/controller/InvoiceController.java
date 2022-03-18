package com.orhaninac.RentACar.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhaninac.RentACar.business.abstracts.InvoiceService;
import com.orhaninac.RentACar.business.dtos.GetInvoiceDto;
import com.orhaninac.RentACar.business.dtos.ListInvoiceDto;
import com.orhaninac.RentACar.business.request.CreateInvoiceRequest;
import com.orhaninac.RentACar.business.request.UpdateInvoiceRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

	private InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@GetMapping("/getall")
	public DataResult<List<ListInvoiceDto>> getAll() {
		return invoiceService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateInvoiceRequest createColorRequest) {
		return this.invoiceService.add(createColorRequest);
	}

	@GetMapping("/getbyid/{id}")
	public DataResult<GetInvoiceDto> getById(@RequestParam int id) {
		return this.invoiceService.getById(id);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@RequestParam int id) {
		return this.invoiceService.delete(id);
	}

	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateInvoiceRequest updateColorRequest) {
		return this.invoiceService.update(updateColorRequest);
	}

	@GetMapping("/getByCustomerId/{id}")
	public DataResult<List<ListInvoiceDto>> getByCustomerId(@RequestParam int id) {
		return this.invoiceService.getByCustomerId(id);
	}



}
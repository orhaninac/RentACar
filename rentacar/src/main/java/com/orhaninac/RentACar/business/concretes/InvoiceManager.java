package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.CarRentalService;
import com.orhaninac.RentACar.business.abstracts.InvoiceService;
import com.orhaninac.RentACar.business.dtos.GetInvoiceDto;
import com.orhaninac.RentACar.business.dtos.ListCarRentalDto;
import com.orhaninac.RentACar.business.dtos.ListInvoiceDto;
import com.orhaninac.RentACar.business.request.CreateInvoiceRequest;
import com.orhaninac.RentACar.business.request.UpdateInvoiceRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;
import com.orhaninac.RentACar.dataAccess.abstracts.InvoiceDao;
import com.orhaninac.RentACar.entities.concretes.CarRental;
import com.orhaninac.RentACar.entities.concretes.Invoice;

@Service
public class InvoiceManager implements InvoiceService {
	
	private InvoiceDao invoiceDao;
	private ModelMapperService modelMapperService;
	private CarRentalService carRentalService; 
	
	public InvoiceManager(InvoiceDao invoiceDao, ModelMapperService modelMapperService,CarRentalService carRentalService) {
		
		super();
		this.invoiceDao = invoiceDao;
		this.modelMapperService = modelMapperService;
		this.carRentalService=carRentalService;
	}


	
	@Override
	public DataResult<List<ListInvoiceDto>> getAll() {
		
		List<Invoice> result = invoiceDao.findAll();
		List<ListInvoiceDto> response = result.stream().map(invoice -> modelMapperService.forDto().map(invoice, ListInvoiceDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListInvoiceDto>>(response, "All invoices listed successfully.");
	}

	@Override
	public Result add(CreateInvoiceRequest createInvoiceRequest) {
		
		Invoice invoice = this.modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
		ListCarRentalDto carRentalDto=carRentalService.getById(createInvoiceRequest.getCarRentalId()).getData();
		CarRental carRental = this.modelMapperService.forRequest().
				map(carRentalDto, CarRental.class);
		invoice.setCustomer(carRental.getCustomer());
		invoice.setRentalPrice(carRental.getRentalPrice());
		invoice.setRentedDate(carRental.getRentDate());
		invoice.setReturnedDate(carRental.getReturnDate());
		invoice.setCustomer(carRental.getCustomer());
		this.invoiceDao.save(invoice);

		return new SuccessResult("Invoice added successfully.");
	}

	@Override
	public DataResult<GetInvoiceDto> getById(int id) {
		
		Invoice invoice = invoiceDao.getById(id);
		GetInvoiceDto response = this.modelMapperService.forDto().map(invoice, GetInvoiceDto.class);

		return new SuccessDataResult<GetInvoiceDto>(response, "Getting invoice by id");
	}

	@Override
	public Result delete(int id) {
		
		this.invoiceDao.deleteById(id);

		return new SuccessResult("Invoice deleted successfully.");
	}

	@Override
	public Result update(UpdateInvoiceRequest updateInvoiceRequest) {
		
		Invoice invoice = this.modelMapperService.forRequest().map(updateInvoiceRequest, Invoice.class);
		this.invoiceDao.save(invoice);

		return new SuccessResult("Invoice updated successfully.");
	}

	@Override
	public DataResult<List<ListInvoiceDto>> getByCustomerId(int customerId) {
		
		List<Invoice> result = invoiceDao.getByCustomer_Id(customerId);
		List<ListInvoiceDto> response = result.stream()
				.map(color -> this.modelMapperService.forDto().map(color, ListInvoiceDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListInvoiceDto>>(response, "Invoices listed successfully.");
	}

}

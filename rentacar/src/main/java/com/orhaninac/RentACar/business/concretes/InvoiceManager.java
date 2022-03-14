package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.InvoiceService;
import com.orhaninac.RentACar.business.dtos.ListCarDto;
import com.orhaninac.RentACar.business.dtos.ListCarRentalDto;
import com.orhaninac.RentACar.business.dtos.ListInvoiceDto;
import com.orhaninac.RentACar.business.request.CreateInvoiceRequest;
import com.orhaninac.RentACar.business.request.UpdateInvoiceRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
import com.orhaninac.RentACar.dataAccess.abstracts.InvoiceDao;
import com.orhaninac.RentACar.entities.concretes.Car;
import com.orhaninac.RentACar.entities.concretes.Invoice;

@Service
public class InvoiceManager implements InvoiceService {
	
	private InvoiceDao invoiceDao;
	private ModelMapperService modelMapperService;
	
	public InvoiceManager(InvoiceDao invoiceDao, ModelMapperService modelMapperService) {
		super();
		this.invoiceDao = invoiceDao;
		this.modelMapperService = modelMapperService;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<ListInvoiceDto> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(UpdateInvoiceRequest updateInvoiceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<ListInvoiceDto>> getByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}

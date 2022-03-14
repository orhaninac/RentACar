package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.ListInvoiceDto;
import com.orhaninac.RentACar.business.request.CreateInvoiceRequest;
import com.orhaninac.RentACar.business.request.UpdateInvoiceRequest;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;

public interface InvoiceService {
	
	DataResult<List<ListInvoiceDto>> getAll();

	Result add(CreateInvoiceRequest createInvoiceRequest);

	DataResult<ListInvoiceDto> getById(int id);

	Result delete(int id);

	Result update(UpdateInvoiceRequest updateInvoiceRequest);

	DataResult<List<ListInvoiceDto>> getByCustomerId(int customerId);

}

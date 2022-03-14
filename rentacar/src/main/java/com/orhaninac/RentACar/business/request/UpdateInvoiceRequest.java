package com.orhaninac.RentACar.business.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class UpdateInvoiceRequest {
	
	@NotNull
	private int invoiceId;
	
	@NotNull
	private int invoiceNumber;

	@NotNull
	private LocalDate invoiceDate;

	@NotNull
	private LocalDate rentedDate;

	@NotNull
	private LocalDate returnedDate;

	@NotNull
	private int rentalPrice;

	@NotNull
	private int customerId;


}

package com.orhaninac.RentACar.business.request;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.orhaninac.RentACar.entities.concretes.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest {

	@NotNull
	private int invoiceNumber;

	@NotNull
	private LocalDate invoiceDate;

//	@NotNull
//	private LocalDate rentedDate;
//
//	@NotNull
//	private LocalDate returnedDate;

//	@NotNull
//	private int rentalPrice;

//	@NotNull
//	private int customerId;
	
	private int carRentalId;

}

package com.orhaninac.RentACar.business.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {
	@NotNull
	private LocalDate paymentDate;

	@NotNull
	private int rentalId;
	
	@NotNull
	private double totalPrice;
	
	@NotNull
	private int customerId;
	
	@NotNull
	private String cardNo;
	
	@NotNull
	private String ccv;
	

}

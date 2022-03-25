package com.orhaninac.RentACar.business.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardDetailsRequest {
	
	private int id;
	private String cardNumber;
	private int customerId;
	private String cardHolder;
	private int cVV;
	private LocalDate expirationDate;
}
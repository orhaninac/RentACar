package com.orhaninac.RentACar.business.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCorporateCustomerRequest {
	
	@Email
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String companyName;
	@NotNull
	private String taxNumber;
}
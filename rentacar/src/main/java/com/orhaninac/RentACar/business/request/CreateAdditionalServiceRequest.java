package com.orhaninac.RentACar.business.request;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdditionalServiceRequest {
	
	@NotNull
	private String name;
	@NotNull
	private int additionalServicePrice;

}

package com.orhaninac.RentACar.business.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarDamageRequest {
	@NotNull
	@Min(1)
	private int carId;
	
	@NotNull
	private String damageDescription;
	
}

package com.orhaninac.RentACar.business.request;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarDamageRequest {
	
	@NotNull
	@Min(1)
	@NotBlank
	private int carDemageId;
	private String damageDescription;
	
	@NotNull
	@Min(1)
	private int carId;

}

package com.orhaninac.RentACar.business.request;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarMaintenanceRequest {
	
	@NotNull
	@Min(1)
	private int carId;
	
	private String description;
	
	@NotNull
	private LocalDate returnDate;


}
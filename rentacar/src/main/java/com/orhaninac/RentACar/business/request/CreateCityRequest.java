package com.orhaninac.RentACar.business.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCityRequest {
	//private String cityName;
	@NotNull
	@Size(min = 2, max = 50)
	private String cityName;
}
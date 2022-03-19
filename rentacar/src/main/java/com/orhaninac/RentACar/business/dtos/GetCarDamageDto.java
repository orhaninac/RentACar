package com.orhaninac.RentACar.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarDamageDto {

	private int id;
	private String damageDescription;
	private int carId;
	

}

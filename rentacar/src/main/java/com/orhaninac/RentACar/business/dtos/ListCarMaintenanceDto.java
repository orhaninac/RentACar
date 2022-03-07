package com.orhaninac.RentACar.business.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarMaintenanceDto {
	
	private int carMaintenanceId;	
	private String description;	
	private LocalDate returnDate;	
	private Integer carId;
	
}

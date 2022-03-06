package com.orhaninac.RentACar.business.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarMaintenanceDto {
	
	private int carMaintenanceId;	
	private String description;	
	private Date returnDate;	
	private Integer carId;
	
}

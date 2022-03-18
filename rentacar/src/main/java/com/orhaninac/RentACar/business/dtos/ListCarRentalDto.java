package com.orhaninac.RentACar.business.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarRentalDto {

	private int carRentalid;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private int customerId;
    private int carId;
    private double totalPrice;
	private List<ListAdditionalServiceDto> addtionalServices;
    
}
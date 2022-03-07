package com.orhaninac.RentACar.business.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRentalRequest {
	
	private int id;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private int customerId;

    private int carId;

}
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
public class CreateCarRentalRequest {
	
	@NotNull
	private LocalDate rentDate;

    private LocalDate returnDate;

	@NotNull
	@Min(1)
    private int customerId;

	@NotNull
	@Min(1)
    private int carId;

}

package com.orhaninac.RentACar.business.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.orhaninac.RentACar.business.dtos.AdditionalServiceIdDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRentalRequest {
	
	@NotNull
	private int carId;

	@NotNull
	private int customerId;

	@NotNull
	private LocalDate rentalDate;

	@Nullable
	private LocalDate returnDate;

	@Nullable
	private List<AdditionalServiceIdDto> additionalServicesIds;

}

package com.orhaninac.RentACar.business.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
	private LocalDate rentDate;

	@Nullable
	private LocalDate returnDate;

	@Nullable
	private List<AdditionalServiceIdDto> additionalServicesIds;
	
	@Positive
	private int rentedCityId;
	@Positive
	private int returnedCityId;
	
	@Positive
	private int startedKm;
	
	@Positive
	private int returnedKm;

}

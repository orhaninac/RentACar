package com.orhaninac.RentACar.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOrderedAdditionalServiceDto {
	private int id;
	private String additionalServiceName;
}

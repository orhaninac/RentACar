package com.orhaninac.RentACar.business.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListPaymentDto {
	private int id;	
	private double totalPayment;	
	private LocalDate paymentDate;
	private int rentalId;	

}

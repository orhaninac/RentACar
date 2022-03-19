package com.orhaninac.RentACar.business.abstracts;

import com.orhaninac.RentACar.entities.concretes.Payment;

public interface PaymentAdapter {
	
	void MakePayment(Payment payment);
	
}

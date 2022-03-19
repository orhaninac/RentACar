package com.orhaninac.RentACar.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "payment_id")
	private int paymentId;
	
	@Column(name="payment_number")
	private String paymentNumber;
	
	@Column(name="payment_date")
	private LocalDate paymentDate;
	
	@Column(name="total_price")
	private double totalPrice;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "car_rental_id")
	private CarRental carRental;
	
		
}

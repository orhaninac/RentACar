package com.orhaninac.RentACar.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="invoices")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "invoice_id")
	private int invoiceId;
	
	@Column(name="invoice_number")
	private int invoiceNumber;
	
	@Column(name="invoiceDate")
	private LocalDate invoiceDate;
	
	@Column(name="invoice_return_date")
	private LocalDate rentedDate; 
	
	@Column(name="invoice_return_date")
	private LocalDate returnedDate; 
	
	@Column(name="rental_price")
	private int rentalPrice;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
	private Customer customer;
}

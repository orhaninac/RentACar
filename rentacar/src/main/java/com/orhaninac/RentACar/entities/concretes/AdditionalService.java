package com.orhaninac.RentACar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "additional_services")
public class AdditionalService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "additional_service_id")
	private int id;
	
	@Column(name = "additional_service_name")
	private String name;
	
	//@Column(name = "additional_service_price")
	//private double additionalServicePrice;
	
	@ManyToMany(mappedBy = "rentalAdditionalServices")
	private List<CarRental> additionalServiceRentals;

}

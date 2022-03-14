package com.orhaninac.RentACar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
public class City {
	//cascadeler silindi
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int id;

	@Column(name = "city_name")
	private String cityName;

	@OneToMany(mappedBy = "rentedCity", fetch = FetchType.LAZY)
	private List<CarRental> rentalCarRented;

	@OneToMany(mappedBy = "returnedCity",  fetch = FetchType.LAZY)
	private List<CarRental> rentalCarReturned;

}

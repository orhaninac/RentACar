package com.orhaninac.RentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int id;
	
	@Column(name = "car_daily_price")
	private double dailyPrice;
	
	@Column(name = "car_model_year")
	private int modelYear;
	
	@Column(name = "car_description")
	private String description;
	
	@JoinColumn(name = "brand_id")
	@ManyToOne
	private Brand brand;
	
	@JoinColumn(name = "color_id")
	@ManyToOne
	private Color color;

}

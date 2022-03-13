package com.orhaninac.RentACar.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car_rentals")
public class CarRental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name="customer_id")
    private int customerId;

    @ManyToOne()
    @JoinColumn(name = "car_id")
    private Car car;
    
    @Column(name = "total_price")
    private double totalPrice;
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ordered_additional_service", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "additional_service_id"))
	private List<AdditionalService> rentalAdditionalServices;
	
    @ManyToOne
    @JoinColumn(name = "rented_city_id")
    private City rentedCity;
    @ManyToOne
    @JoinColumn(name = "returned_city_id")
    private City returnedCity;
   

}

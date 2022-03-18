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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@Column(name = "car_rental_id")
	private int id;
	
	@Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "return_date")
    private LocalDate returnDate;
    
    @Column(name="started_km")
    private int startedKm;
    
    @Column(name="returned_km")
    private int returnedKm;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name = "car_id")
    private Car car;
    
    @Column(name = "total_price")
    private double totalPrice=0.0;
    
	@OneToMany(mappedBy = "carRental", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<OrderedAdditionalService> orderedAdditionalServices;
	
    @ManyToOne
    @JoinColumn(name = "rented_city_id")
    private City rentedCity;
    @ManyToOne
    @JoinColumn(name = "returned_city_id")
    private City returnedCity;
    
	@Column(name = "rental_daily_price")
	private double rentalPrice;
   
	@OneToOne(mappedBy = "carRental")
	private Invoice invoice;

}

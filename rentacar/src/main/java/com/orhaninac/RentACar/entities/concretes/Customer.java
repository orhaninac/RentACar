package com.orhaninac.RentACar.entities.concretes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "customer_id")
@Builder(builderMethodName = "customerBuilder")
public class Customer extends User{
	
	//cascade silindi
    //@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    //List<CarRental> carRentalList;

}

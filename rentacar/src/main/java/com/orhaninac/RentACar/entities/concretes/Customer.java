package com.orhaninac.RentACar.entities.concretes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customers")
@EqualsAndHashCode(callSuper=false)
public class Customer extends User{
	
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    List<CarRental> carRentalList;


}

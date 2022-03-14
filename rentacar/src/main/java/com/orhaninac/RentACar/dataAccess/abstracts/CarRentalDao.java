package com.orhaninac.RentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orhaninac.RentACar.entities.concretes.CarRental;

@Repository
public interface CarRentalDao extends JpaRepository<CarRental, Integer>{
	
	CarRental findById(int id);
	List<CarRental> findByCar_CarId(int carId);
	//List<CarRental> findByCar_CustomerId(int customerId);
	//List<CarMaintenance> findByCar_CarId(int carId);

}

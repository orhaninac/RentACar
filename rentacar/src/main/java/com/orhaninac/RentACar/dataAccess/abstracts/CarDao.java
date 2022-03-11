package com.orhaninac.RentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orhaninac.RentACar.entities.concretes.Car;

public interface CarDao extends JpaRepository<Car, Integer>{
	Car findById(int id);
	List<Car> findByDailyPriceLessThanEqual(double dailyPrice);

}

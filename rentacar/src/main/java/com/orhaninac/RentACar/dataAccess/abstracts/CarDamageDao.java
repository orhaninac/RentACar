package com.orhaninac.RentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orhaninac.RentACar.entities.concretes.CarDamage;
import com.orhaninac.RentACar.entities.concretes.CarMaintenance;

@Repository
public interface CarDamageDao extends JpaRepository<CarDamage, Integer>{
	List<CarDamage> findByCar_CarId(int carId);

}

package com.orhaninac.RentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.orhaninac.RentACar.entities.concretes.CarMaintenance;

@Repository
public interface CarMaintenanceDao extends JpaRepository<CarMaintenance, Integer> {
	List<CarMaintenance> findByCar_CarId(int carId);
	CarMaintenance findById(int id);
}
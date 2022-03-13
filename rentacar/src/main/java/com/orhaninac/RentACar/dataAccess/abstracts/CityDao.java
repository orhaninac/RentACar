package com.orhaninac.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orhaninac.RentACar.entities.concretes.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {
	
	City getCityById(int id);

	City getCityByCityName(String name);

}
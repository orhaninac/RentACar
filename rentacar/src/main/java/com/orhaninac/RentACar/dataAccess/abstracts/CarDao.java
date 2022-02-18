package com.orhaninac.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orhaninac.RentACar.entities.concretes.Car;



public interface CarDao extends JpaRepository<Car, Integer>{

}

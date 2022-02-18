package com.orhaninac.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orhaninac.RentACar.entities.concretes.Color;


@Repository
public interface ColorDao extends JpaRepository<Color, Integer> {

	Color getByColorName(String name);
}

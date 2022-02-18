package com.orhaninac.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orhaninac.RentACar.entities.concretes.Brand;


@Repository
public interface BrandDao extends JpaRepository<Brand, Integer> {

	Brand getByBrandName(String name);
}

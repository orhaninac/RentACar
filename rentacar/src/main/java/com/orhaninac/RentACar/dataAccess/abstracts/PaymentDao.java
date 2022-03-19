package com.orhaninac.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orhaninac.RentACar.entities.concretes.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer> {

}

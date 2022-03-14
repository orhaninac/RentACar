package com.orhaninac.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orhaninac.RentACar.entities.concretes.IndividualCustomer;
import com.orhaninac.RentACar.entities.concretes.Invoice;

@Repository
public interface InvoiceDao extends JpaRepository<Invoice, Integer> {

}
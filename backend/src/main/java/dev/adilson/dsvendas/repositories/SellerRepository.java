package dev.adilson.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.adilson.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}

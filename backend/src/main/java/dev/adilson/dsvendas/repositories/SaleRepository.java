package dev.adilson.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.adilson.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}

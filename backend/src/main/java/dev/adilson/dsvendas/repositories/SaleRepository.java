package dev.adilson.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.adilson.dsvendas.dto.SaleSuccessDTO;
import dev.adilson.dsvendas.dto.SalesSumDTO;
import dev.adilson.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new dev.adilson.dsvendas.dto.SalesSumDTO(obj.seller, SUM(obj.amount))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SalesSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new dev.adilson.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}

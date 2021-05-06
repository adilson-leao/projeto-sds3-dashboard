package dev.adilson.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.adilson.dsvendas.dto.SaleDTO;
import dev.adilson.dsvendas.dto.SaleSuccessDTO;
import dev.adilson.dsvendas.dto.SalesSumDTO;
import dev.adilson.dsvendas.entities.Sale;
import dev.adilson.dsvendas.repositories.SaleRepository;
import dev.adilson.dsvendas.repositories.SellerRepository;

@Service
public class SaleService  {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly= true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly= true)
	public List<SalesSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly= true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}

	
}

package com.crud.project.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.crud.project.entity.Product;
import com.crud.project.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productrepo;
	
	public List<Product> findAll(Pageable pageable){
		return productrepo.findAll();
		
	}
	
	public Optional<Product> findById(Long id) {
		return productrepo.findById(id);
	}
	
	public Product save(Product product) {
		return productrepo.save(product);
	}
	
	public  void deleteById(Long id) {
		productrepo.deleteById(id);
	}
	
}

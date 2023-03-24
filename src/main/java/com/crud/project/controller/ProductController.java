package com.crud.project.controller;




import java.awt.print.Pageable;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.project.entity.Product;
import com.crud.project.repository.CategoryRepository;
import com.crud.project.repository.ProductRepository;
import com.crud.project.service.ProductService;

import ch.qos.logback.core.model.Model;


@RestController

public class ProductController {
	
	@Autowired
	private ProductRepository pr;
	
	@Autowired
	private CategoryRepository cr;
	
	  
	  @GetMapping("/products")
	  public String listProducts(Model model,
	                             @RequestParam(defaultValue = "0") int page,
	                             @RequestParam(defaultValue = "10") int size) {
	    PageRequest pageable = PageRequest.of(page, size);
	    Page<Product> products = pr.findAll(pageable);

	    model.addAttribute("products", products);
	    return "products";
	  }

	  @GetMapping("/products/new")
	  public String newProductForm(Model model) {
	    model.addAttribute("product", new Product());
	    model.addAttribute("categories", cr.findAll());
	    return "product-form";
	  }

	  @PostMapping("/products/save")
	  public String saveProduct(@ModelAttribute("product") Product product) {
	    productRepository.save(product);
	    return "redirect:/products";
	  }

	  @GetMapping("/products/edit/{id}")
	  public String editProductForm(@PathVariable("id") Long id, Model model) {
	    java.util.Optional<Product> product = pr.findById(id);
	    if (product.isPresent()) {
	      model.addAttribute("product", product.get());
	      model.addAttribute("categories", cr.findAll()); 
	      return "product-form"; 
	      } 
	    else { 
	    	return "redirect:/products"; 
	    	} 
	    }
	  @GetMapping("/products/delete/{id}") 
	  public String deleteProduct(@PathVariable("id") Long id) 
	  
	  { pr.deleteById(id); 
	  return "redirect:/products"; 
	  }
	  
}
	  
}

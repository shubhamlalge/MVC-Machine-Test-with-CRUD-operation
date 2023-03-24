package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Product;
import com.crud.repository.ProductRepository;


@RestController
public class ProductController {
	
	@Autowired
	ProductRepository pr;
	
	@PostMapping("/saveproduct")
	public void saveUser(@RequestBody Product p) {
		pr.save(p);
		System.out.println("data inserted succesfully");
		
	}
	
	@GetMapping("/getproduct")
	public Product getData(@RequestParam int id) {
		Optional<Product> op = pr.findById(id);
		return op.get();
		
	}
	
	@GetMapping("/getallproduct")
	
		public List<Product> getAllData(){
			return pr.findAll();
		}
	

    @DeleteMapping("/deleteproduct")
    public String deleteData(@RequestParam int id) {
    	pr.deleteById(id);
    	return "data deleted";
    }
    
    @PutMapping("/updateproduct")
    public void updateUser(@RequestBody Product p) {
    	
    	pr.save(p);
    }

}

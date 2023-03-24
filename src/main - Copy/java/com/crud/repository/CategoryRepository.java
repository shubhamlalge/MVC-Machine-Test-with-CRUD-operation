package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

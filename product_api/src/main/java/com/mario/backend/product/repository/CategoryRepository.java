package com.mario.backend.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mario.backend.product.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}

package com.id.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
   @Query("select p from Product p where p.name like:x")
	public Page<Product>chercher(@Param("x")String mc,Pageable pageable);
}

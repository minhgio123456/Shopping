package com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{
	@Query(value = "SELECT TOP 6 * FROM Product",nativeQuery = true)
	List<Product> findTop6();

	@Query(value = "SELECT * FROM Product WHERE ProBrand_id=?1",nativeQuery = true)
	List<Product> findByProbrandId(Integer id);
}

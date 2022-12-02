package com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Product_Brand")
public class ProductBrand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer probrand_id;
	String probrand_name;
	Boolean probrand_isdelete;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product_brand")
	List<Product> products;
}

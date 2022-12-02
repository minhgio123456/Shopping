package com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer product_id;
	String product_name;
	Double product_price;
	String product_img;
	String product_desc;
	Integer product_quantity;
	Boolean product_isdelete;
	
	@ManyToOne @JoinColumn(name = "probrand_id")
	ProductBrand product_brand;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Voucher_Data> voucher_datas;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product_")
	List<Order_Details> order_details;
	
}

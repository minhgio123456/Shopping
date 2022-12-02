package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{

}

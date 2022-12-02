package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Voucher;

public interface VoucherDAO extends JpaRepository<Voucher, Integer>{

}

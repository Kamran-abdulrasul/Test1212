package com.example.ingressdemo.dao.repository;

import com.example.ingressdemo.dao.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {
}

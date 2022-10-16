package com.example.ingressdemo.mapper;

import com.example.ingressdemo.dao.entity.PaymentEntity;
import com.example.ingressdemo.model.PaymentRequest;
import com.example.ingressdemo.model.PaymentResponse;

import java.time.LocalDateTime;

public class PaymentMapper {
    public static PaymentEntity mapRequestToEntity(PaymentRequest request){
        return PaymentEntity.builder()
                .amount(request.getAmount())
                .description(request.getDescription())
                .build();

    }

    public static PaymentResponse mapEntityToResponse(PaymentEntity entity){
        return PaymentResponse.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .description((entity.getDescription()))
                .responseAt((LocalDateTime.now()))
                .build();
    }

    public static void updatePayment(PaymentRequest request, PaymentEntity entity){
        entity.setAmount(request.getAmount());
        entity.setDescription(request.getDescription());
    }
}

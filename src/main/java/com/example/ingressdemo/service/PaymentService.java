package com.example.ingressdemo.service;

import com.example.ingressdemo.dao.entity.PaymentEntity;
import com.example.ingressdemo.dao.repository.PaymentRepository;
import com.example.ingressdemo.mapper.PaymentMapper;
import com.example.ingressdemo.model.PaymentRequest;
import com.example.ingressdemo.model.PaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.ingressdemo.mapper.PaymentMapper.mapEntityToResponse;
import static com.example.ingressdemo.mapper.PaymentMapper.mapRequestToEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public void savePayment(PaymentRequest request) {
        log.info("ActionLog.savePayment.start");
        paymentRepository.save(mapRequestToEntity(request));
        log.info("ActionLog.savePayment.success");
    }


    public PaymentResponse getPayment(Long id) {
        log.info("ActionLog.getPayment.start id:{}", id);
        var payment = fetchPaymentIfExist(id);
        return mapEntityToResponse(payment);

    }


    public List<PaymentResponse> getPayments() {
        log.info("ActionLog.getPayments.start ");
        var payments = paymentRepository.findAll().stream()
                .map(PaymentMapper::mapEntityToResponse)
                .collect(Collectors.toList());
        log.info("ActionLog.getPayments.success ");
        return payments;
    }

    public void updatePayment(Long id, PaymentRequest request) {
        log.info("ActionLog.updatePayment.start id:{}", id);
        var payment = fetchPaymentIfExist(id);
        PaymentMapper.updatePayment(request, payment);
        paymentRepository.save(payment);
        log.info("ActionLog.updatePayment.success id:{}", id);


    }

    private PaymentEntity fetchPaymentIfExist(Long id) {
        return paymentRepository.findById(id).orElseThrow(() ->
                {
                    log.error("ActionLog.getPayment.start id:{}", id);
                    return new RuntimeException("PAYMENT_NOT_FOUND");
                }
        );
    }
}

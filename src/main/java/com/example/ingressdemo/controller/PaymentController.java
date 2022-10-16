package com.example.ingressdemo.controller;

import com.example.ingressdemo.model.PaymentRequest;
import com.example.ingressdemo.model.PaymentResponse;
import com.example.ingressdemo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void savePayment(@RequestBody PaymentRequest request){
        paymentService.savePayment(request);
    }

    @GetMapping("/{id}")
    public PaymentResponse getPayment(@PathVariable Long id){
        return paymentService.getPayment(id);
    }

    @GetMapping
    public List<PaymentResponse> getPayments(){
        return paymentService.getPayments();
    }
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updatePayment(@PathVariable Long id,@RequestBody PaymentRequest request){
        paymentService.updatePayment(id, request);
    }
}

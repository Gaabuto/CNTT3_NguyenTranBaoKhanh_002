package com.example.demo.src.refactoring.strategy.payment;

import com.example.demo.src.refactoring.strategy.PaymentStrategy;

public class VNPayPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Routing to VNPay Health portal...");
    }
}

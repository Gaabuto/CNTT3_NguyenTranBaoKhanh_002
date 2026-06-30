package com.example.demo.src.refactoring.strategy.payment;

import com.example.demo.src.refactoring.strategy.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Print receipt for counter...");
    }
}
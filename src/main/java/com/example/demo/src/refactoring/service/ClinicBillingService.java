package com.example.demo.src.refactoring.service;

import com.example.demo.src.refactoring.strategy.InsuranceStrategy;
import com.example.demo.src.refactoring.strategy.NotificationStrategy;
import com.example.demo.src.refactoring.strategy.PaymentStrategy;

public class ClinicBillingService {

    private final InsuranceStrategy insuranceStrategy;
    private final PaymentStrategy paymentStrategy;
    private final NotificationStrategy notificationStrategy;

    public ClinicBillingService(InsuranceStrategy insuranceStrategy,
                                PaymentStrategy paymentStrategy,
                                NotificationStrategy notificationStrategy) {
        this.insuranceStrategy = insuranceStrategy;
        this.paymentStrategy = paymentStrategy;
        this.notificationStrategy = notificationStrategy;
    }

    public Invoice calculateAndPay(Patient patient, VisitRecord visit) {

        if (!patient.isActive()) {
            throw new RuntimeException("Patient record locked");
        }

        // Tính tổng phí khám
        double totalFee = visit.getBaseFee();

        for (ServiceItem item : visit.getExtraServices()) {
            totalFee += item.getFee();
        }

        // Áp dụng bảo hiểm
        if (insuranceStrategy != null) {
            totalFee = insuranceStrategy.apply(totalFee);
        }

        // Thanh toán
        paymentStrategy.pay();

        // Gửi thông báo
        notificationStrategy.send(patient.getPhone());

        return new Invoice(patient, totalFee, "PAID");
    }
}
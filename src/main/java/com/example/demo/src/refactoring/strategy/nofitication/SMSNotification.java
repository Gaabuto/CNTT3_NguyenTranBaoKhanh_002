package com.example.demo.src.refactoring.strategy.nofitication;

import com.example.demo.src.refactoring.strategy.NotificationStrategy;

public class SMSNotification implements NotificationStrategy {

    @Override
    public void send(String phone) {
        System.out.println("Sending SMS to " + phone + " for billing info...");
    }
}
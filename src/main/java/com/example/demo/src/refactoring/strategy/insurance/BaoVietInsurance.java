package com.example.demo.src.refactoring.strategy.insurance;

import com.example.demo.src.refactoring.strategy.InsuranceStrategy;

public class BaoVietInsurance implements InsuranceStrategy {
    @Override
    public double apply(double fee) {
        return fee - 500000;
    }
}
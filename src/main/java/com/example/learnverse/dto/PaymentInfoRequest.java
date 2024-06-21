package com.example.learnverse.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentInfoRequest {
    private Long amount;
    private String currency;
    private String receiptEmail;
    private Long studentId;
    private Long courseId;
}
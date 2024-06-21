package com.example.learnverse.controllers;


import com.example.learnverse.dto.PaymentInfoRequest;
import com.example.learnverse.services.impl.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.learnverse.utilities.JWTUtils.payloadJWTExtraction;


@RestController
@RequestMapping("/api/payment/secure")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoRequest paymentInfoRequest)
            throws StripeException {

        // Create a PaymentIntent
        PaymentIntentCreateParams createParams = PaymentIntentCreateParams.builder()
                .setAmount(paymentInfoRequest.getAmount()) // Amount in cents (e.g., $10.00)
                .setCurrency(paymentInfoRequest.getCurrency())
                .setConfirm(true) // Confirm the PaymentIntent immediately
                .setReturnUrl("https://www.example.com/success") // Specify your return URL
                .putMetadata("studentId", String.valueOf(paymentInfoRequest.getStudentId())) // Add custom metadata
                .putMetadata("courseId", String.valueOf(paymentInfoRequest.getCourseId()))
                .setPaymentMethod("pm_card_visa")
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(createParams);

        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
}

    @PutMapping("/payment-complete")
    public ResponseEntity<String> stripePaymentComplete(@RequestHeader(value="Authorization") String token)
            throws Exception {
        String userEmail = payloadJWTExtraction(token, "\"sub\"");
        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        return paymentService.stripePayment(userEmail);
    }
}
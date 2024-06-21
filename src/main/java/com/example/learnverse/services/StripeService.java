package com.example.learnverse.services;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.security.dto.JpaUserDto;
import com.stripe.exception.StripeException;

public interface StripeService {
    public void createStripeCustomer(JpaUserDto jpaUserDto) throws StripeException;
    public void createStripeProduct(CourseDto courseDto) throws StripeException;

}

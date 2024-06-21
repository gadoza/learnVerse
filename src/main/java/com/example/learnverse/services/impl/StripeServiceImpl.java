package com.example.learnverse.services.impl;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.services.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Product;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.ProductCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StripeServiceImpl implements StripeService {
    @Override
    public void createStripeCustomer(JpaUserDto userDto) throws StripeException {
        CustomerCreateParams params =
                CustomerCreateParams.builder()
                        .setName(userDto.getUserName())
                        .setEmail(userDto.getEmail())
                        .build();
        Customer customer = Customer.create(params);
    }

    @Override
    public void createStripeProduct(CourseDto courseDto) throws StripeException {
        ProductCreateParams params =
                ProductCreateParams.builder()
                        .setName(courseDto.getCourseName())
                        .setDescription(courseDto.getDescription())
                        .setDefaultPriceData(new ProductCreateParams.DefaultPriceData.Builder().setCurrency("usd").setUnitAmount(courseDto.getPrice().longValue() * 100).build())
                        .build();
        Product product = Product.create(params);
    }
}

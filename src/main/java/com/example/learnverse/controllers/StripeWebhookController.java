package com.example.learnverse.controllers;

import com.example.learnverse.entities.Course;
import com.example.learnverse.repositories.CourseRepository;
import com.example.learnverse.security.entities.JpaUser;
import com.example.learnverse.security.repositories.JpaUserRepository;
import com.example.learnverse.security.service.JpaUserDetailsService;
import com.example.learnverse.services.CourseService;
import com.example.learnverse.services.EnrollmentService;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.PaymentIntent;
import com.stripe.net.Webhook;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class StripeWebhookController {

    private final EnrollmentService enrollmentService;
    private final CourseRepository courseRepository;
    private final JpaUserRepository jpaUserRepository;

    //!!!!!!!change if changed in stripe!!!!!!!!!!!!
    private static final String endpointSecret = "whsec_0UHskHXiBTD1W2efngO4OzDhJt88S874";

    @PostMapping("/stripe-webhook")
    public String handleStripeWebhook(@RequestBody String payload, HttpServletRequest request) throws StripeException {
        String sigHeader = request.getHeader("Stripe-Signature");

        Event event = null;

        try {
            event = Webhook.constructEvent(
                    payload, sigHeader, endpointSecret
            );
        } catch (SignatureVerificationException e) {
            // Invalid signature
            return "Signature verification failed";
        }

        // Handle the event
        switch (event.getType()) {
            case "payment_intent.succeeded":

                PaymentIntent paymentIntent = (PaymentIntent) event.getDataObjectDeserializer()
                        .getObject().orElse(null);

                if (paymentIntent != null) {
                    String courseId = paymentIntent.getMetadata().get("courseId");
                    String studentId = paymentIntent.getMetadata().get("studentId");

                    //get Course and Student entity to finish enrollment
                    Course enrolledCourse = courseRepository.getReferenceById(Long.valueOf(courseId));
                    JpaUser enrolledStudent = jpaUserRepository.getReferenceById(Long.valueOf(studentId));
                    enrollmentService.enroll(enrolledCourse, enrolledStudent);

                    /* student must be enrolled in case of successful payment*/

                }



                break;
            case "payment_intent.payment_failed":
                System.out.println("-------the payment failed--------------");
                // The payment failed
                break;
            // ... handle other event types
            default:
                return "Unhandled event type";
        }

        return "Success";
    }
}


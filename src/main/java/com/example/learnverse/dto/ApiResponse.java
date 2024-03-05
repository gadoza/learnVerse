package com.example.learnverse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    @Builder.Default
    private Boolean success = true;
    @Builder.Default
    private Integer code = HttpStatus.OK.value();
    private T payload;
    private String serviceTime;


    public static <T> ApiResponse<T> ok(T payload) {
        return status(HttpStatus.OK, payload, null);
    }

    public static <T> ApiResponse<T> created(T payload) {
        return status(HttpStatus.CREATED, payload, LocalDateTime.now().toString());
    }

    public static <T> ApiResponse<T> accepted(T payload) {
        return status(HttpStatus.ACCEPTED, payload, null);
    }

    public static <T> ApiResponse<T> ok(T payload, String serviceTime) {
        return status(HttpStatus.OK, payload, serviceTime);
    }

    public static <T> ApiResponse<T> created(T payload, String serviceTime) {
        return status(HttpStatus.CREATED, payload, serviceTime);
    }

    public static <T> ApiResponse<T> accepted(T payload, String serviceTime) {
        return status(HttpStatus.ACCEPTED, payload, serviceTime);
    }

    private static <T> ApiResponse<T> status(HttpStatus status, T payload, String serviceTime) {
        return new ApiResponse<>(true, status.value(), payload, serviceTime);
    }

    public static <T> ApiResponse<T> noContent() {
        return status(HttpStatus.NO_CONTENT, null, null);
    }

}
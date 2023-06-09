package com.board.practice.react.board.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {
    private LocalDateTime transactionTime;
    private String resultCode;
    private String description;
    private T data;
    private Pagination pagination;

    @SuppressWarnings("unchecked")
    public static <T> Header<T> OK() {
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    @SuppressWarnings("unchecked")
    public static <T> Header<T> OK(T data) {
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .data(data)
                .resultCode("OK")
                .description("OK")
                .build();
    }

    @SuppressWarnings("unchecked")
    public static <T> Header<T> OK(T data, Pagination pagination) {
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .pagination(pagination)
                .build();
    }

    @SuppressWarnings("unchecked")
    public static <T> Header<T> ERROR(String description) {
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }
}

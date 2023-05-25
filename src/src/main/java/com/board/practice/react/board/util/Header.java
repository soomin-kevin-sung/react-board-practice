package com.board.practice.react.board.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {
    private String resultCode;
    private String description;
    private T data;
    private Pagination pagination;

    public static <T> Header<T> OK() {
        return null;
    }

    public static <T> Header<T> OK(T data) {
        return null;
    }

    public static <T> Header<T> OK(T data, Pagination pagination) {
        return null;
    }

    public static <T> Header<T> ERROR(String description) {
        return null;
    }
}

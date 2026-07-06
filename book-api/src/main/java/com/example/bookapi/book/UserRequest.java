package com.example.bookapi.book;

public record UserRequest(
        String name,
        String passwd,
        Integer age,
        Integer birth
) {
}

package com.example.bookapi.book;

public record UserResponse(
        Long id,
        String name,
        String passwd,
        Integer age,
        Integer birth
) {
    public static UserResponse from(Users users) {
        return new UserResponse(
                users.getId(),
                users.getName(),
                users.getPasswd(),
                users.getAge(),
                users.getBirth()
        );
    }
}

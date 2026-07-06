package com.example.bookapi.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new Users("김관용", "1234", 24, 2003));
                userRepository.save(new Users("홍길동", "1234", 33, 1998));
                userRepository.save(new Users("아무개", "1234", 34, 1997));
            }
        };
    }
}

package com.bee.spring.student;

import java.time.LocalDate;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mariam = new Student("mariam", "mariam@163.com", LocalDate.of(2003, 2, 3));
            Student bai = new Student("bai", "bai@163.com", LocalDate.of(2001, 1, 1));
            studentRepository.saveAll(Arrays.asList(mariam, bai));
        };
    }
}

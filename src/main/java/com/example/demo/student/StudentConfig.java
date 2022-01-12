package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository) {
//        return args -> {
//            Student hazel = new Student(
//                    1L,
//                    "Hazel",
//                    LocalDate.of(1999, JULY, 15),
//                    "hoang@gmail.com"
//            );
//
//            Student alex = new Student(
//                    2L,
//                    "Alex",
//                    LocalDate.of(2005, JULY, 15),
//                    "alex@gmail.com"
//            );
//
//            repository.saveAll(
//                    List.of(hazel, alex)
//            );
//        };
//    }
//}

package com.example.sms_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}

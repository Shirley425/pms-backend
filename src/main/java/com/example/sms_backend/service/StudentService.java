package com.example.sms_backend.service;

import com.example.sms_backend.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);
    List<StudentDto> getAllStudents();
    List<StudentDto> searchStudents(String name);
    StudentDto updateStudent(Long id, StudentDto studentDto);
    void deleteStudent(Long id);
}

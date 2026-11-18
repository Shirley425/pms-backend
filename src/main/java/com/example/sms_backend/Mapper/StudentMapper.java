package com.example.sms_backend.Mapper;

import com.example.sms_backend.dto.StudentDto;
import com.example.sms_backend.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getPhoneNumber()
        );
    }

    public static Student mapToStudent(StudentDto studentDto){
        return  new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getPhoneNumber()
        );
    }

}

package com.example.sms_backend.service.impl;

import com.example.sms_backend.Mapper.StudentMapper;
import com.example.sms_backend.dto.StudentDto;
import com.example.sms_backend.entity.Student;
import com.example.sms_backend.repository.StudentRepository;
import com.example.sms_backend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceimpl implements StudentService {
    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student does not exist"));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentMapper::mapToStudentDto).toList();
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student does not exist"));

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setPhoneNumber(studentDto.getPhoneNumber());

        Student updatedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student does not exist"));
        studentRepository.delete(student);
    }
}

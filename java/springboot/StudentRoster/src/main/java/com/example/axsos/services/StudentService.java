package com.example.axsos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.axsos.models.Student;
import com.example.axsos.repositories.StudentRepository;


@Service

public class StudentService {
	@Autowired
	private StudentRepository studentRepositories;

	public List<Student> findAllStudent() {
		return studentRepositories.findAll();
	}

	public Student createStudent(Student ninja) {
		return studentRepositories.save(ninja);
	}

	public Student findStudent(Long id) {
		return studentRepositories.findById(id).orElse(null);
	}

public void deleteStudent(Long id) {
	Optional<Student> optionalStudent = studentRepositories.findById(id);
	if (optionalStudent.isPresent()) {
		studentRepositories.deleteById(id);
	}

}
public List<Student> findAllUnassigned() {
    return studentRepositories.findByDormIsNull();
}

    
}
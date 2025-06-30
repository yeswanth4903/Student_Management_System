package com.yash.Service;


import com.yash.Model.Student;
import com.yash.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents(Sort id) {
        return studentRepo.findAll();
    }

    public void save(Student student) {
        studentRepo.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

}


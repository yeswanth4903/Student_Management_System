package com.yash.Repo;


import com.yash.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByName(String name); // Spring Data JPA will implement this automatically
}


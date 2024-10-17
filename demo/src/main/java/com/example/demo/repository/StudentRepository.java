package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import com.example.demo.repository.GradeRepository;



@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
}

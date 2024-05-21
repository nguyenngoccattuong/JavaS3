package com.hutech.javas3d3.Repositories;

import com.hutech.javas3d3.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}

package com.swabhav.crud.repository;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swabhav.crud.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByRollnumberOrNameOrAge(int rollnumber, String name, int age);
}

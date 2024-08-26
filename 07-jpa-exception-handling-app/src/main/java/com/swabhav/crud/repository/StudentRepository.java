package com.swabhav.crud.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swabhav.crud.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findByRollnumberOrNameOrAge(int rollnumber, String name, int age, Pageable page);
}

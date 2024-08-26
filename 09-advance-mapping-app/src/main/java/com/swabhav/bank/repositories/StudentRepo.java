package com.swabhav.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swabhav.bank.entities.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}

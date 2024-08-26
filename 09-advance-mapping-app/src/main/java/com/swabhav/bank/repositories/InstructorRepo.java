package com.swabhav.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swabhav.bank.entities.Instructor;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Integer>{

}

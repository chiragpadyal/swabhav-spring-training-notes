package com.swabhav.employee.service.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swabhav.employee.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> query = manager.createQuery("select e from Employee e", Employee.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void addEmployee(Employee emp) {
		manager.persist(emp);
	}

	@Override
	public Employee getEmployee(int id) {
		return manager.find(Employee.class, id);
	}

}

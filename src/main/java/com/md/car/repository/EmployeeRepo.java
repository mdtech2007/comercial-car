package com.md.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.md.car.hr.models.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}

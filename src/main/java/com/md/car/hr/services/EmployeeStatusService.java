package com.md.car.hr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.car.hr.models.EmployeeStatus;
import com.md.car.hr.repositories.EmployeeStatusRepository;

@Service
public class EmployeeStatusService {

    @Autowired
    private EmployeeStatusRepository employeeStatusRepository;

    //Get All EmployeeStatuss
    public List<EmployeeStatus> findAll(){
        return employeeStatusRepository.findAll();
    }

    //Get EmployeeStatus By Id
    public Optional<EmployeeStatus> findById(int id) {
        return employeeStatusRepository.findById(id);
    }

    //Delete EmployeeStatus
    public void delete(int id) {
        employeeStatusRepository.deleteById(id);
    }

    //Update EmployeeStatus
    public void save( EmployeeStatus employeeStatus) {
        employeeStatusRepository.save(employeeStatus);
    }
}

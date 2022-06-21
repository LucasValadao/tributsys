package com.pw.tributsys.service;

import com.pw.tributsys.exception.UserNotFoundException;
import com.pw.tributsys.model.Employee;
import com.pw.tributsys.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {

        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){

        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){

        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("Usuario com id" + id +" nao foi encontrado"));
    }

    public void deleteEmployee(Long id){

        employeeRepo.deleteEmployeeById(id);
    }
}

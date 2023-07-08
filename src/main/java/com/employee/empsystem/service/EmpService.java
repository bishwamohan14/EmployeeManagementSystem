package com.employee.empsystem.service;

import com.employee.empsystem.entity.Employee;
import com.employee.empsystem.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepo repo;


    public void addEmp(Employee employee){
        repo.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return repo.findAll();
    }

    public Employee getEmpById(int id)
    {
        Optional<Employee> employee=repo.findById(id);
        if(employee.isPresent())
        {
            return employee.get();
        }
        return null;
    }

    public void deleteEmp(int id)
    {
       repo.deleteById(id);
    }


}

package com.employee.empsystem.repository;

import com.employee.empsystem.entity.Employee;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer>{

}

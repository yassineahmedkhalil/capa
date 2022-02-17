package com.capaboard.capa.repositories;

import com.capaboard.capa.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> getEmployeeByFirstName(String firstName);
}

package com.capaboard.capa.repositories;

import com.capaboard.capa.entities.Employee;
import com.capaboard.capa.entities.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void addEmployee(){

        Employee ahmed = Employee.builder()
                .firstName("Ahmed")
                .lastName("Yassine")
                .build();

        Employee amin = Employee.builder()
                .firstName("amin")
                .lastName("zouari")
                .build();

        employeeRepository.saveAll(List.of(ahmed,amin));
    }

    @Test
    public void addEmployeeWithProjects(){

        Project project1 = Project.builder()
                .projectName("project1")
                .projectDescription("Project description")
                .build();

        Employee ahmed = Employee.builder()
                .firstName("Ahmed")
                .lastName("Yassine")
                .projects(List.of(project1))
                .build();

        employeeRepository.saveAll(List.of(ahmed));
    }
}
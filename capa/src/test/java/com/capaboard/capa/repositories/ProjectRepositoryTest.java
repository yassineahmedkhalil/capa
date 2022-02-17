package com.capaboard.capa.repositories;

import com.capaboard.capa.entities.Company;
import com.capaboard.capa.entities.Employee;
import com.capaboard.capa.entities.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void addProject(){
        Employee employee = Employee.builder()
                .lastName("Olaf")
                .firstName("Scholz")
                .build();

        Project api = Project.builder()
                .projectDescription("develop a API")
                .projectName("API")
                .employees(List.of(employee))
                .build();

        projectRepository.saveAll(List.of(api));
    }

    @Test
    public void addProjectWithCompany(){
        Company company = Company.builder()
                .companyName("cegeka")
                .build();

        Employee employee = Employee.builder()
                .lastName("Olaf")
                .firstName("Scholz")
                .build();

        Project api = Project.builder()
                .projectDescription("develop a API")
                .projectName("API")
                .company(company)
                .employees(List.of(employee))
                .build();

        projectRepository.saveAll(List.of(api));
    }
    
    @Test
    public void printAllProjects(){
        List<Project> projects = projectRepository.findAll();
        System.out.println("projects = " + projects);
    }
}
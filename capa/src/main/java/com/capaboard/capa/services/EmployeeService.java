package com.capaboard.capa.services;

import com.capaboard.capa.entities.Employee;
import com.capaboard.capa.entities.Project;
import com.capaboard.capa.repositories.EmployeeRepository;
import com.capaboard.capa.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public EmployeeService(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeByEmployeeId(Long id){

        return employeeRepository.findById(id);
    }

    public List<Employee> findEmployeeByFirstName(String firstName) {

        return employeeRepository.getEmployeeByFirstName(firstName);
    }

    public void deleteEmployeeById(Long id) {

        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Employee employee, Long id) {

        Project updateProject = projectRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("project not found"));

        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Employee does not exist"+ id ));
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setFirstName(employee.getFirstName());

        Project project = new Project();
        project.setProjectId(updateProject.getProjectId());
        project.setProjectName(updateProject.getProjectName());
        project.setProjectDescription(updateProject.getProjectDescription());

        updateEmployee.setProjects(List.of(project));

        employeeRepository.save(updateEmployee);
    }
}

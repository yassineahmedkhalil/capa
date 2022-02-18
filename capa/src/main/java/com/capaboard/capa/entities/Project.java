package com.capaboard.capa.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Project {

    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )
    private Long projectId;
    private String projectName;
    private String projectDescription;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "project_id",
            referencedColumnName = "projectId"
    )
    private List<Employee> employees;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "company_id",
            referencedColumnName = "companyId"
    )
    private Company company;
}
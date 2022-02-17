package com.capaboard.capa.repositories;

import com.capaboard.capa.entities.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void addCompany(){

        Company ba = Company.builder()
                .companyName("BA")
                .build();

        Company puma = Company.builder()
                .companyName("Puma")
                .build();
        companyRepository.saveAll(List.of(ba,puma));
    }
}
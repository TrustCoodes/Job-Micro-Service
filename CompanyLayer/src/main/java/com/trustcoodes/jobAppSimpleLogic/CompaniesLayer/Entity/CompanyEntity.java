package com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "CompanyData")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String info;
}
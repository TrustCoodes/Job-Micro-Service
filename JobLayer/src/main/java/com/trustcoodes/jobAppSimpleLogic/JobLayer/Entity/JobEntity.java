package com.trustcoodes.jobAppSimpleLogic.JobLayer.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "JobData")
//@Table(name = "app_table")
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String role;
    private String officeLocation;
    private String minSalary;
    private String maxSalary;
    private Long companyEntity;

}

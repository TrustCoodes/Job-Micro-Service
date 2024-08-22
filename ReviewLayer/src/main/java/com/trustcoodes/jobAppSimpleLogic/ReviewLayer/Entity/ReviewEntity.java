package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String heading;
    private String info;
    private double reviewRating;
    private Long companyId;
}
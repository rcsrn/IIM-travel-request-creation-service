package com.iim.service.persistency.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "concept")
@Data
public class Concept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "concept_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "travel_request_id")
    private TravelRequest travelRequest;

    @Column(name = "concept_type")
    private String conceptType;

    @Column(name = "project_number")
    private Long projectNumber;

    @Column(name = "inscription", precision = 10, scale = 2)
    private BigDecimal inscription;

    @Column(name = "fare", precision = 10, scale = 2)
    private BigDecimal fare;

    @Column(name = "per_diem", precision = 10, scale = 2)
    private BigDecimal perDiem;
}

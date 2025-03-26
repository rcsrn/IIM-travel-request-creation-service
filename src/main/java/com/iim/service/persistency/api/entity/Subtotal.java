package com.iim.service.persistency.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "subtotal")
@Data
public class Subtotal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subtotal_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "travel_request_id")
    private TravelRequest travelRequest;

    @Column(name = "subtotal_inscription" , precision = 10, scale = 2)
    private BigDecimal inscription;

    @Column(name = "subtotal_fare", precision = 10, scale = 2)
    private BigDecimal fare;

    @Column(name = "subtotal_per_diem", precision = 10, scale = 2)
    private BigDecimal perDiem;

}

package com.iim.service.persistency.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "travel_request")
@Data
public class TravelRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_request_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Column(name = "type_request")
    private String type;

    @Column(name = "place")
    private String place;

    @Column(name = "motive")
    private String motive;

    @Column(name = "activity")
    private String activity;

    @Column(name = "job")
    private String job;

    @Column(name = "modality")
    private String modality;

    @Column(name = "serie")
    private String serie;

    @NotNull
    @Column(name = "start_date_request")
    private LocalDateTime startDateRequest;

    @NotNull
    @Column(name = "end_date_request")
    private LocalDateTime endDateRequest;

    @NotNull
    @Column(name = "start_date_absence")
    private LocalDateTime startDateAbsence;

    @NotNull
    @Column(name = "end_date_absence")
    private LocalDateTime endDateAbsence;

    @NotNull
    @Column(name = "insurance_first_name")
    private String insuranceFirstName;

    @Column(name = "insurance_second_name")
    private String insuranceSecondName;

    @NotNull
    @Column(name = "insurance_first_last_name")
    private String insuranceFirstLastName;

    @NotNull
    @Column(name = "insurance_second_last_name")
    private String insuranceSecondLastName;

    @NotNull
    @Column(name = "insurance_kinship")
    private String insuranceKinship;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}

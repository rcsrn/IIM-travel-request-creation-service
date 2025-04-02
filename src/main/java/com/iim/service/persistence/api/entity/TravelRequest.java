package com.iim.service.persistence.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.iim.service.persistence.api.mapper.LocalDateTimeDeserializer;
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

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern="dd-MM-YYYY")
    @Column(name = "start_date_request")
    private LocalDateTime startDateRequest;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern="dd-MM-YYYY")
    @Column(name = "end_date_request")
    private LocalDateTime endDateRequest;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern="dd-MM-YYYY")
    @Column(name = "start_date_absence")
    private LocalDateTime startDateAbsence;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern="dd-MM-YYYY")
    @Column(name = "end_date_absence")
    private LocalDateTime endDateAbsence;

    @Column(name = "insurance_first_name")
    private String insuranceFirstName;

    @Column(name = "insurance_second_name")
    private String insuranceSecondName;

    @Column(name = "insurance_first_last_name")
    private String insuranceFirstLastName;

    @Column(name = "insurance_second_last_name")
    private String insuranceSecondLastName;

    @Column(name = "insurance_kinship")
    private String insuranceKinship;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}

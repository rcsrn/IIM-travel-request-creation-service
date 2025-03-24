package com.iim.service.persistency.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TravelRequestDTO {

    private String type;

    private String place;

    private String motive;

    private String activity;

    private String job;

    private String modality;

    private String serie;

    private LocalDateTime startDateRequest;

    private LocalDateTime endDateRequest;

    private LocalDateTime startDateAbsence;

    private LocalDateTime endDateAbsence;

    private String insuranceFirstName;

    private String insuranceSecondName;

    private String insuranceFirstLastName;

    private String insuranceSecondLastName;

    private String insuranceKinship;

    private BigDecimal totalPrice;
}

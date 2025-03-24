package com.iim.service.persistency.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

import static com.iim.service.persistency.api.constant.Constants.*;

@Data
public class TravelRequestDTO {

    @NotNull
    @NotBlank(message = NO_REQUEST_TYPE_MESSAGE)
    private String type;

    private String place;

    private String motive;

    private String activity;

    private String job;

    private String modality;

    private String serie;

    @NotNull
    @NotBlank(message = NO_START_REQUEST_DATE_MESSAGE)
    private LocalDateTime startDateRequest;

    @NotNull
    @NotBlank(message = NO_END_REQUEST_DATE_MESSAGE)
    private LocalDateTime endDateRequest;

    @NotNull
    @NotBlank(message = NO_START_ABSENCE_DATE_MESSAGE)
    private LocalDateTime startDateAbsence;

    @NotNull
    @NotBlank(message = NO_END_ABSENCE_DATE_MESSAGE)
    private LocalDateTime endDateAbsence;

    @NotNull
    @NotBlank(message = NO_FIRST_NAME_MESSAGE)
    private String insuranceFirstName;

    private String insuranceSecondName;

    @NotNull
    @NotBlank(message = NO_FIRST_LAST_NAME_MESSAGE)
    private String insuranceFirstLastName;

    @NotNull
    @NotBlank(message = NO_SECOND_LAST_NAME_MESSAGE)
    private String insuranceSecondLastName;

    @NotNull
    @NotBlank(message = NO_KINSHIP_MESSAGE)
    private String insuranceKinship;
}

package com.iim.service.persistence.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.time.LocalDateTime;

import static com.iim.service.persistence.api.constant.ValidationMessages.*;

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

    @Pattern(regexp = "^(SV001|SV1001)$", message = SERIE_ALLOWED_VALUES_MESSAGE)
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

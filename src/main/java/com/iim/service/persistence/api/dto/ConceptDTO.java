package com.iim.service.persistence.api.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import static com.iim.service.persistence.api.constant.ValidationMessages.CONCEPT_TYPE_ALLOWED_VALUES_MESSAGE;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConceptDTO {

    private Long projectNumber;

    @Pattern(regexp = "^(IIM|PAPIIT|CONACYT|OTROS)$", message = CONCEPT_TYPE_ALLOWED_VALUES_MESSAGE)
    private String conceptType;

    @Digits(integer=8, fraction=2)
    private BigDecimal inscription;

    @Digits(integer=8, fraction=2)
    private BigDecimal fare;

    @Digits(integer=8, fraction=2)
    private BigDecimal perDiem;
}

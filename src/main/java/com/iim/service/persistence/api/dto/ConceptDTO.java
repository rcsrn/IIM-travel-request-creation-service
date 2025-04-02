package com.iim.service.persistence.api.dto;

import jakarta.validation.constraints.Pattern;
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

    private BigDecimal inscription;

    private BigDecimal fare;

    private BigDecimal perDiem;
}

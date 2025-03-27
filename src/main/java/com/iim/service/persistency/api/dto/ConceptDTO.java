package com.iim.service.persistency.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConceptDTO {

    private Long projectNumber;

    private String conceptType;

    private BigDecimal inscription;

    private BigDecimal fare;

    private BigDecimal perDiem;
}

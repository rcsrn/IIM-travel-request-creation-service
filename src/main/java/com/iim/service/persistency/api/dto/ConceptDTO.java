package com.iim.service.persistency.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConceptDTO {

    private Long projectNumber;

    private String conceptType;

    private BigDecimal inscription;

    private BigDecimal fare;

    private BigDecimal perDiem;
}

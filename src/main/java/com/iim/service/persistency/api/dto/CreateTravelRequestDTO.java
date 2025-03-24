package com.iim.service.persistency.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateTravelRequestDTO {
    private UserDTO userDTO;

    private TravelRequestDTO travelRequestDTO;

    private List<ConceptDTO> conceptDTO;
}

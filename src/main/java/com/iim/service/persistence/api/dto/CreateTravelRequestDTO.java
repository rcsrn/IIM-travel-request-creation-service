package com.iim.service.persistence.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

import static com.iim.service.persistence.api.constant.ValidationMessages.MAX_CONCEPT_LIST_SIZE_MESSAGE;

@Data
public class CreateTravelRequestDTO {
    @Valid
    private UserDTO userDTO;

    @Valid
    private TravelRequestDTO travelRequestDTO;

    @Valid
    @Size(max = 4, message = MAX_CONCEPT_LIST_SIZE_MESSAGE)
    private List<ConceptDTO> concepts;
}

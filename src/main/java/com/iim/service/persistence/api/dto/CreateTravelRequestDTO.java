package com.iim.service.persistence.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

import static com.iim.service.persistence.api.constant.ValidationMessages.MAX_CONCEPT_LIST_SIZE_MESSAGE;
import static com.iim.service.persistence.api.constant.ValidationMessages.NULL_TRAVEL_REQUEST_MESSAGE;
import static com.iim.service.persistence.api.constant.ValidationMessages.NULL_USER_MESSAGE;

@Data
public class CreateTravelRequestDTO {

    @Valid
    @NotNull(message = NULL_USER_MESSAGE)
    private UserDTO userDTO;

    @Valid
    @NotNull(message = NULL_TRAVEL_REQUEST_MESSAGE)
    private TravelRequestDTO travelRequestDTO;

    @Valid
    @Size(max = 4, message = MAX_CONCEPT_LIST_SIZE_MESSAGE)
    private List<ConceptDTO> concepts;
}

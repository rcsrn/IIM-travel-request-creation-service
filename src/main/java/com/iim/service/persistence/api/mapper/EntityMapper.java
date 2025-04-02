package com.iim.service.persistence.api.mapper;

import com.iim.service.persistence.api.dto.ConceptDTO;
import com.iim.service.persistence.api.dto.TravelRequestDTO;
import com.iim.service.persistence.api.dto.UserDTO;
import com.iim.service.persistence.api.entity.Concept;
import com.iim.service.persistence.api.entity.TravelRequest;
import com.iim.service.persistence.api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    @Mapping(target = "id", ignore = true)
    User mapUserDtoToUser(UserDTO input);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    TravelRequest mapTravelRequestDtoToTravelRequest(TravelRequestDTO input);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "travelRequest", ignore = true)
    Concept mapConceptDtoToConcept(ConceptDTO input);
}

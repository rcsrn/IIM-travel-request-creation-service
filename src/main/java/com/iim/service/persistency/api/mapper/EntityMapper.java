package com.iim.service.persistency.api.mapper;

import com.iim.service.persistency.api.dto.ConceptDTO;
import com.iim.service.persistency.api.dto.TravelRequestDTO;
import com.iim.service.persistency.api.dto.UserDTO;
import com.iim.service.persistency.api.entity.Concept;
import com.iim.service.persistency.api.entity.TravelRequest;
import com.iim.service.persistency.api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    @Mapping(target = "id", ignore = true)
    User mapToUser(UserDTO input);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    TravelRequest mapToTravelRequest(TravelRequestDTO input);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "travelRequest", ignore = true)
    Concept mapToConcept(ConceptDTO input);
}

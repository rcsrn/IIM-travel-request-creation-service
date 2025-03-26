package com.iim.service.persistency.api.mapper;

import com.iim.service.persistency.api.dto.ConceptDTO;
import com.iim.service.persistency.api.dto.TravelRequestDTO;
import com.iim.service.persistency.api.dto.UserDTO;
import com.iim.service.persistency.api.entity.Concept;
import com.iim.service.persistency.api.entity.TravelRequest;
import com.iim.service.persistency.api.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface EntityMapper {
    User mapToUser(UserDTO input);

    TravelRequest mapToTravelRequest(TravelRequestDTO input);

    @AfterMapping
    default void setUser(@MappingTarget TravelRequest travelRequest, User user) {
        travelRequest.setUser(user);
    }

    Concept mapToConcept(ConceptDTO input);

}

package com.iim.service.persistency.util;

import com.iim.service.persistency.api.dto.ConceptDTO;
import com.iim.service.persistency.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistency.api.dto.TravelRequestDTO;
import com.iim.service.persistency.api.dto.UserDTO;
import com.iim.service.persistency.api.entity.Subtotal;
import com.iim.service.persistency.api.entity.TravelRequest;
import com.iim.service.persistency.api.entity.User;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDataFactory {
    private TestDataFactory() {}

    private final static PodamFactory podamFactory = new PodamFactoryImpl();

    public static User buildUser() {
        return podamFactory.manufacturePojo(User.class);
    }

    public static TravelRequest buildTravelRequest() {
        TravelRequest travelRequest =  podamFactory.manufacturePojo(TravelRequest.class);
        travelRequest.setSerie("SV001");
        return travelRequest;
    }

    public static CreateTravelRequestDTO buildCreateTravelRequestDTO() {
        CreateTravelRequestDTO createTravelRequestDTO = podamFactory.manufacturePojo(CreateTravelRequestDTO.class);
        createTravelRequestDTO.setConcepts(Collections.singletonList(new ConceptDTO(1L, "type", new BigDecimal("10.21"), new BigDecimal("20.01"), new BigDecimal("302.1231230"))));
        return createTravelRequestDTO;
    }

    public static CreateTravelRequestDTO buildCreateTravelRequestDTOWithNoConcepts() {
        CreateTravelRequestDTO createTravelRequestDTO = podamFactory.manufacturePojo(CreateTravelRequestDTO.class);
        createTravelRequestDTO.setConcepts(null);
        return createTravelRequestDTO;
    }

    public static UserDTO buildUserDto() {
        return podamFactory.manufacturePojo(UserDTO.class);
    }

}

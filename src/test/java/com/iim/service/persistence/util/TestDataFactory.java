package com.iim.service.persistence.util;

import com.iim.service.persistence.api.dto.ConceptDTO;
import com.iim.service.persistence.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistence.api.dto.TravelRequestDTO;
import com.iim.service.persistence.api.dto.UserDTO;
import com.iim.service.persistence.api.entity.TravelRequest;
import com.iim.service.persistence.api.entity.User;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.math.BigDecimal;
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
        travelRequest.setTotalPrice(new BigDecimal("1531.21"));
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

    public static TravelRequestDTO buildTravelRequestDto() {
        return podamFactory.manufacturePojo(TravelRequestDTO.class);
    }

    public static ConceptDTO buildConceptDto() {
        return podamFactory.manufacturePojo(ConceptDTO.class);
    }

    public static CreateTravelRequestDTO buildCompliantCreateTravelRequestDto() {
        CreateTravelRequestDTO createTravelRequestDTO = podamFactory.manufacturePojo(CreateTravelRequestDTO.class);
        List<ConceptDTO> conceptDTOS = createTravelRequestDTO.getConcepts();
        conceptDTOS.clear();
        for (int i = 0; i < 4; i++) {
            conceptDTOS.add(generateCompliantConceptDto());
        }
        TravelRequestDTO travelRequestDTO = createTravelRequestDTO.getTravelRequestDTO();
        travelRequestDTO.setSerie("SV1001");

        return createTravelRequestDTO;
    }

    private static ConceptDTO generateCompliantConceptDto() {
        ConceptDTO conceptDTO = podamFactory.manufacturePojo(ConceptDTO.class);
        conceptDTO.setConceptType("CONACYT");
        return conceptDTO;
    }

    public static CreateTravelRequestDTO buildNonCompliantCreateTravelRequestDto() {
        return podamFactory.manufacturePojo(CreateTravelRequestDTO.class);
    }
}

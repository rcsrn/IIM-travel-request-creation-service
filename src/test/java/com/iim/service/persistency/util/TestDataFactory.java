package com.iim.service.persistency.util;

import com.iim.service.persistency.api.dto.ConceptDTO;
import com.iim.service.persistency.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistency.api.dto.TravelRequestDTO;
import com.iim.service.persistency.api.dto.UserDTO;
import com.iim.service.persistency.api.entity.Subtotal;
import com.iim.service.persistency.api.entity.TravelRequest;
import com.iim.service.persistency.api.entity.User;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestDataFactory {
    private TestDataFactory() {}

    public static User buildUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Juan");
        user.setSecondName("Carlos");
        user.setFirstLastName("Lopez");
        user.setSecondLastName("Perez");
        user.setRole("Admin");
        return user;
    }

    public static TravelRequest buildTravelRequest() {
        LocalDateTime nowDate = LocalDateTime.now();

        TravelRequest travelRequest = new TravelRequest();
        travelRequest.setId(1L);
        travelRequest.setUser(buildUser());
        travelRequest.setPlace("Guadalajara MX");
        travelRequest.setMotive("concurso de programacion");
        travelRequest.setActivity("calificacion de programas");
        travelRequest.setJob("juez");
        travelRequest.setModality("Presencial");
        travelRequest.setSerie("SV001");
        travelRequest.setStartDateRequest(nowDate);
        travelRequest.setEndDateRequest(nowDate.plusDays(20));
        travelRequest.setStartDateAbsence(nowDate.plusDays(1));
        travelRequest.setEndDateAbsence(nowDate.plusDays(19));
        travelRequest.setInsuranceFirstName("Pedro");
        travelRequest.setInsuranceFirstLastName("Hernandez");
        travelRequest.setInsuranceSecondLastName("Rodríguez");
        travelRequest.setInsuranceKinship("Padre");
        travelRequest.setTotalPrice(new BigDecimal("1601.61"));
        return travelRequest;
    }

    private CreateTravelRequestDTO buildCreateTravelRequestDTO() {
        CreateTravelRequestDTO createTravelRequestDTO = new CreateTravelRequestDTO();

        createTravelRequestDTO.setTravelRequestDTO(buoldTravelRequestDTO());

        createTravelRequestDTO.setUserDTO(buildUserDTO());

        createTravelRequestDTO.setConcepts(buildConceptDTOList());

        return createTravelRequestDTO;
    }

    private List<ConceptDTO> buildConceptDTOList() {
        List<ConceptDTO> conceptDTOList = new ArrayList<>();
        conceptDTOList.add(new ConceptDTO(1L, "CONACYT", new BigDecimal("123.125156"), new BigDecimal("0.0"), new BigDecimal("0")));
        conceptDTOList.add(new ConceptDTO(1L, "CONACYT", new BigDecimal("123.125156"), new BigDecimal("156.48"), new BigDecimal("0")));
        conceptDTOList.add(new ConceptDTO(1L, "CONACYT", new BigDecimal("123.12235156"), new BigDecimal("156.4"), new BigDecimal("0")));
        return conceptDTOList;
    }

    private UserDTO buildUserDTO() {
        return null;
    }

    private TravelRequestDTO buoldTravelRequestDTO() {
        return null;
    }

    private Subtotal buildSubtotal() {
        Subtotal subtotal = new Subtotal();
        subtotal.setId(1L);
        subtotal.setTravelRequest(buildTravelRequest());
        subtotal.setInscription(new BigDecimal("153.15"));
        subtotal.setFare(new BigDecimal("1321.10"));
        subtotal.setPerDiem(new BigDecimal("1684.99"));
        return subtotal;
    }
}

package com.iim.service.persistency.api.service;

import com.iim.service.persistency.api.entity.Concept;
import com.iim.service.persistency.api.entity.Subtotal;
import com.iim.service.persistency.api.entity.TravelRequest;
import com.iim.service.persistency.api.entity.User;
import com.iim.service.persistency.api.repository.ConceptRepository;
import com.iim.service.persistency.api.repository.SubtotalRepository;
import com.iim.service.persistency.api.repository.TravelRequestRepository;
import com.iim.service.persistency.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class TravelRequestServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TravelRequestRepository travelRequestRepository;

    @Mock
    private ConceptRepository conceptRepository;

    @Mock
    private SubtotalRepository subtotalRepository;

    @InjectMocks
    private TravelRequestServiceImpl travelRequestService;

    @Test
    void createTravelRequest_whenThereAreConcepts_ShouldSaveEntities() {

    }

    private User generateUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Juan");
        user.setSecondName("Carlos");
        user.setFirstLastName("Lopez");
        user.setSecondLastName("Perez");
        user.setRole("Admin");
        return user;
    }

    private TravelRequest generateTravelRequest() {
        LocalDateTime nowDate = LocalDateTime.now();

        TravelRequest travelRequest = new TravelRequest();
        travelRequest.setId(1L);
        travelRequest.setUser(generateUser());
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


    private Subtotal generateSubtotal() {
        Subtotal subtotal = new Subtotal();
        subtotal.setId(1L);
        subtotal.setTravelRequest(generateTravelRequest());
        subtotal.setInscription(new BigDecimal("153.15"));
        subtotal.setFare(new BigDecimal("1321.10"));
        subtotal.setPerDiem(new BigDecimal("1684.99"));
        return subtotal;
    }
}

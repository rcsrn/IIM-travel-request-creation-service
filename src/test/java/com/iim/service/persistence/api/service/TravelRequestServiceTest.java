package com.iim.service.persistence.api.service;

import com.iim.service.persistence.api.entity.Concept;
import com.iim.service.persistence.api.entity.Subtotal;
import com.iim.service.persistence.api.entity.TravelRequest;
import com.iim.service.persistence.api.entity.User;
import com.iim.service.persistence.api.repository.ConceptRepository;
import com.iim.service.persistence.api.repository.SubtotalRepository;
import com.iim.service.persistence.api.repository.TravelRequestRepository;
import com.iim.service.persistence.api.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.iim.service.persistence.util.TestDataFactory.*;

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
    void createTravelRequest_whenThereAreConcepts_ShouldReturnTravelRequest() {
        TravelRequest savedTravelRequest = buildTravelRequest();

        Mockito.when(userRepository.save(Mockito.any())).thenReturn(buildUser());
        Mockito.when(travelRequestRepository.save(Mockito.any())).thenReturn(savedTravelRequest);
        Mockito.when(subtotalRepository.save(Mockito.any())).thenReturn(new Subtotal());
        Mockito.when(conceptRepository.save(Mockito.any())).thenReturn(new Concept());

        TravelRequest returnedTravelRequest = travelRequestService.createTravelRequest(buildCreateTravelRequestDTO());

        Assertions.assertNotNull(returnedTravelRequest);
        Assertions.assertSame(savedTravelRequest, returnedTravelRequest);
        Mockito.verify(userRepository).save(Mockito.any(User.class));
        Mockito.verify(travelRequestRepository).save(Mockito.any(TravelRequest.class));
        Mockito.verify(subtotalRepository).save(Mockito.any(Subtotal.class));
        Mockito.verify(conceptRepository).save(Mockito.any(Concept.class));
    }

    @Test
    void createTravelRequest_whenThereAreNotConcepts_ShouldReturnTravelRequest() {
        TravelRequest savedTravelRequest = buildTravelRequest();

        Mockito.when(userRepository.save(Mockito.any())).thenReturn(buildUser());
        Mockito.when(travelRequestRepository.save(Mockito.any())).thenReturn(savedTravelRequest);

        TravelRequest returnedTravelRequest = travelRequestService.createTravelRequest(buildCreateTravelRequestDTOWithNoConcepts());

        Assertions.assertNotNull(returnedTravelRequest);
        Assertions.assertSame(savedTravelRequest, returnedTravelRequest);
        Mockito.verify(userRepository).save(Mockito.any(User.class));
        Mockito.verify(travelRequestRepository).save(Mockito.any(TravelRequest.class));
    }


}

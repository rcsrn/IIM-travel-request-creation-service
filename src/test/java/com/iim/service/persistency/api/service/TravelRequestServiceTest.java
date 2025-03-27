package com.iim.service.persistency.api.service;

import com.iim.service.persistency.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistency.api.entity.Concept;
import com.iim.service.persistency.api.entity.Subtotal;
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

import static com.iim.service.persistency.util.TestDataFactory.*;

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
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(buildUser());
        Mockito.when(travelRequestRepository.save(Mockito.any())).thenReturn(buildTravelRequest());
        Mockito.when(subtotalRepository.save(Mockito.any())).thenReturn(new Subtotal());
        Mockito.when(conceptRepository.save(Mockito.any())).thenReturn(new Concept());

        travelRequestService.createTravelRequest(new CreateTravelRequestDTO());
    }

}

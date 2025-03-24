package com.iim.service.persistency.api.service;

import com.iim.service.persistency.api.dto.CreateTravelRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface TravelRequestService {
    void createTravelRequest(CreateTravelRequestDTO input);
}

package com.iim.service.persistency.api.service;

import com.iim.service.persistency.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistency.api.entity.TravelRequest;
import org.springframework.stereotype.Service;

public interface TravelRequestService {
    TravelRequest createTravelRequest(CreateTravelRequestDTO input);
}

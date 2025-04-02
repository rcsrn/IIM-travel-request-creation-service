package com.iim.service.persistence.api.service;

import com.iim.service.persistence.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistence.api.entity.TravelRequest;

public interface TravelRequestService {
    TravelRequest createTravelRequest(CreateTravelRequestDTO input);
}

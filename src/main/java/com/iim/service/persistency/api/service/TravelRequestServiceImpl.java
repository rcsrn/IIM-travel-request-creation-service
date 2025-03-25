package com.iim.service.persistency.api.service;

import com.iim.service.persistency.api.dto.ConceptDTO;
import com.iim.service.persistency.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistency.api.entity.Subtotal;
import com.iim.service.persistency.api.entity.TravelRequest;
import com.iim.service.persistency.api.entity.User;
import com.iim.service.persistency.api.mapper.EntityMapper;
import com.iim.service.persistency.api.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TravelRequestServiceImpl implements TravelRequestService{

    @Autowired
    private UserRepository userRepository;

    private final static EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);

    @Override
    public void createTravelRequest(CreateTravelRequestDTO input) {
        User user = entityMapper.mapToUser(input.getUserDTO());
        TravelRequest travelRequest = entityMapper.mapToTravelRequest(input.getTravelRequestDTO());
        Subtotal subtotal = calculateSubtotal(input.getConcepts());
    }

    private Subtotal calculateSubtotal(List<ConceptDTO> conceptDTO) {
        return null;
    }
}

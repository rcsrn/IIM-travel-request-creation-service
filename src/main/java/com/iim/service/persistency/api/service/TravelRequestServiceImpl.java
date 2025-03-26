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


import java.math.BigDecimal;
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

    private Subtotal calculateSubtotal(List<ConceptDTO> concepts) {
        if (concepts.isEmpty())
            return null;

        Subtotal subtotal = new Subtotal();
        BigDecimal inscription = new BigDecimal("0.0");
        BigDecimal fare = new BigDecimal("0.0");
        BigDecimal perDiem = new BigDecimal("0.0");

        for (ConceptDTO concept : concepts) {
            if (hasNonZeroValue(concept.getInscription())) {
                inscription = inscription.add(concept.getInscription());
            }
            if (hasNonZeroValue(concept.getFare())) {
                fare = fare.add(concept.getFare());
            }
            if (hasNonZeroValue(concept.getPerDiem())) {
                perDiem = perDiem.add(concept.getPerDiem());
            }
        }

        if (hasNonZeroValue(inscription))
            subtotal.setInscription(inscription);
        if (hasNonZeroValue(fare))
            subtotal.setFare(fare);
        if (hasNonZeroValue(perDiem))
            subtotal.setPerDiem(perDiem);

        return subtotal;
    }

    private boolean hasNonZeroValue(BigDecimal value) {
        return  (value != null) && !(value.compareTo(BigDecimal.ZERO) == 0);
    }
}

package com.iim.service.persistency.api.service;

import com.iim.service.persistency.api.dto.ConceptDTO;
import com.iim.service.persistency.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistency.api.entity.Concept;
import com.iim.service.persistency.api.entity.Subtotal;
import com.iim.service.persistency.api.entity.TravelRequest;
import com.iim.service.persistency.api.entity.User;
import com.iim.service.persistency.api.mapper.EntityMapper;
import com.iim.service.persistency.api.repository.ConceptRepository;
import com.iim.service.persistency.api.repository.SubtotalRepository;
import com.iim.service.persistency.api.repository.TravelRequestRepository;
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

    @Autowired
    private TravelRequestRepository travelRequestRepository;

    @Autowired
    private ConceptRepository conceptRepository;

    @Autowired
    private SubtotalRepository subtotalRepository;

    private final static EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);

    @Override
    public TravelRequest createTravelRequest(CreateTravelRequestDTO input) {
        User user = entityMapper.mapUserDtoToUser(input.getUserDTO());
        TravelRequest travelRequest = entityMapper.mapTravelRequestDtoToTravelRequest(input.getTravelRequestDTO());
        Subtotal subtotals = calculateSubtotals(input.getConcepts());

        if (subtotals != null)
            travelRequest.setTotalPrice(calculateTotal(subtotals));

        User userSaved = userRepository.save(user);
        travelRequest.setUser(userSaved);
        TravelRequest travelRequestSaved = travelRequestRepository.save(travelRequest);
        saveSubtotals(subtotals, travelRequestSaved);
        saveConcepts(input.getConcepts(), travelRequestSaved);

        return travelRequestSaved;
    }

    private void saveSubtotals(Subtotal subtotals, TravelRequest travelRequest) {
        if (subtotals == null)
            return;
        subtotals.setTravelRequest(travelRequest);
        subtotalRepository.save(subtotals);
    }

    private void saveConcepts(List<ConceptDTO> conceptDTOS, TravelRequest travelRequest) {
        if (conceptDTOS == null || conceptDTOS.isEmpty())
            return;

        for (ConceptDTO conceptDTO : conceptDTOS) {
            Concept concept = entityMapper.mapConceptDtoToConcept(conceptDTO);
            concept.setTravelRequest(travelRequest);
            conceptRepository.save(concept);
        }
    }


    private BigDecimal calculateTotal(Subtotal subtotals) {
        return subtotals.getInscription().add(subtotals.getFare()).add(subtotals.getPerDiem());
    }

    private Subtotal calculateSubtotals(List<ConceptDTO> concepts) {
        if (concepts == null || concepts.isEmpty())
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

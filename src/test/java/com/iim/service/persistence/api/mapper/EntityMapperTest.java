package com.iim.service.persistence.api.mapper;

import com.iim.service.persistence.api.dto.ConceptDTO;
import com.iim.service.persistence.api.dto.TravelRequestDTO;
import com.iim.service.persistence.api.dto.UserDTO;
import com.iim.service.persistence.api.entity.Concept;
import com.iim.service.persistence.api.entity.TravelRequest;
import com.iim.service.persistence.api.entity.User;
import com.iim.service.persistence.util.TestDataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EntityMapperTest {

    private final static EntityMapper mapper = Mappers.getMapper(EntityMapper.class);

    @Test
    public void mapUserToDtoToUser_WhenUserDtoIsComplete_ShouldMapJustGivenValues() {
        UserDTO userDto = TestDataFactory.buildUserDto();
        User user = mapper.mapUserDtoToUser(userDto);

        Assertions.assertNotNull(user);
        Assertions.assertNull(user.getId());
        Assertions.assertEquals(userDto.getFirstName(), user.getFirstName());
        Assertions.assertEquals(userDto.getSecondName(), user.getSecondName());
        Assertions.assertEquals(userDto.getFirstLastName(), user.getFirstLastName());
        Assertions.assertEquals(userDto.getSecondLastName(), user.getSecondLastName());
        Assertions.assertEquals(userDto.getRole(), user.getRole());
    }

    @Test
    public void mapTravelRequestDtoToTravelRequest_WhenTravelRequestDtoIsComplete_ShouldMapJustGivenValues() {
        TravelRequestDTO travelRequestDTO = TestDataFactory.buildTravelRequestDto();
        TravelRequest travelRequest = mapper.mapTravelRequestDtoToTravelRequest(travelRequestDTO);

        Assertions.assertNotNull(travelRequest);
        Assertions.assertNull(travelRequest.getId());
        Assertions.assertNull(travelRequest.getUser());
        Assertions.assertNull(travelRequest.getTotalPrice());
        Assertions.assertEquals(travelRequestDTO.getType(), travelRequest.getType());
        Assertions.assertEquals(travelRequestDTO.getPlace(), travelRequest.getPlace());
        Assertions.assertEquals(travelRequestDTO.getMotive(), travelRequest.getMotive());
        Assertions.assertEquals(travelRequestDTO.getActivity(), travelRequest.getActivity());
        Assertions.assertEquals(travelRequestDTO.getModality(), travelRequest.getModality());
        Assertions.assertEquals(travelRequestDTO.getSerie(), travelRequest.getSerie());
        Assertions.assertEquals(travelRequestDTO.getStartDateRequest(), travelRequest.getStartDateRequest());
        Assertions.assertEquals(travelRequestDTO.getEndDateRequest(), travelRequest.getEndDateRequest());
        Assertions.assertEquals(travelRequestDTO.getStartDateAbsence(), travelRequest.getStartDateAbsence());
        Assertions.assertEquals(travelRequestDTO.getEndDateAbsence(), travelRequest.getEndDateAbsence());
        Assertions.assertEquals(travelRequestDTO.getInsuranceFirstName(), travelRequest.getInsuranceFirstName());
        Assertions.assertEquals(travelRequestDTO.getInsuranceSecondName(), travelRequest.getInsuranceSecondName());
        Assertions.assertEquals(travelRequestDTO.getInsuranceFirstLastName(), travelRequest.getInsuranceFirstLastName());
        Assertions.assertEquals(travelRequestDTO.getInsuranceSecondLastName(), travelRequest.getInsuranceSecondLastName());
        Assertions.assertEquals(travelRequestDTO.getInsuranceKinship(), travelRequest.getInsuranceKinship());
    }

    @Test
    public void mapConceptDtoToConcept_WhenConceptDtoIsComplete_ShouldMapJustGivenValues() {
        ConceptDTO conceptDTO = TestDataFactory.buildConceptDto();
        Concept concept = mapper.mapConceptDtoToConcept(conceptDTO);

        Assertions.assertNotNull(concept);
        Assertions.assertNull(concept.getId());
        Assertions.assertNull(concept.getTravelRequest());
        Assertions.assertEquals(conceptDTO.getConceptType(), concept.getConceptType());
        Assertions.assertEquals(conceptDTO.getProjectNumber(), concept.getProjectNumber());
        Assertions.assertEquals(conceptDTO.getInscription(), concept.getInscription());
        Assertions.assertEquals(conceptDTO.getFare(), concept.getFare());
        Assertions.assertEquals(conceptDTO.getPerDiem(), concept.getPerDiem());
    }
}

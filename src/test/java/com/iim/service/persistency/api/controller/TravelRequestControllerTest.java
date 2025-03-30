package com.iim.service.persistency.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iim.service.persistency.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistency.api.entity.TravelRequest;
import com.iim.service.persistency.api.service.TravelRequestService;
import com.iim.service.persistency.util.TestDataFactory;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static com.iim.service.persistency.api.constant.Paths.baseUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(controllers = TravelRequestController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class TravelRequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockitoBean
    private TravelRequestService travelRequestService;

    private static CreateTravelRequestDTO compliantCreateRequestDTO;

    private static CreateTravelRequestDTO nonCompliantCreateRequestDTO;

    private static TravelRequest travelRequest;

    @BeforeAll
    static void init() {
        compliantCreateRequestDTO = TestDataFactory.buildCompliantCreateTravelRequestDto();
        travelRequest = TestDataFactory.buildTravelRequest();
        nonCompliantCreateRequestDTO = TestDataFactory.buildNonCompliantCreateTravelRequestDto();
    }

    @Test
    void createTravelRequest_WhenItCompliesAllConstraints_ReturnedTravelRequest() throws Exception {
        when(travelRequestService.createTravelRequest(any())).thenReturn(travelRequest);

        ResultActions response = mockMvc.perform(post(baseUrl)
						 .contentType(MediaType.APPLICATION_JSON)
						 .content(mapper.writeValueAsString(compliantCreateRequestDTO)));

        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(travelRequest.getId())));
	    response.andExpect(MockMvcResultMatchers.jsonPath("$.user.id", CoreMatchers.is(travelRequest.getUser().getId())));
	    response.andExpect(MockMvcResultMatchers.jsonPath("$.user.firstName", CoreMatchers.is(travelRequest.getUser().getFirstName())));
	    response.andExpect(MockMvcResultMatchers.jsonPath("$.user.secondName", CoreMatchers.is(travelRequest.getUser().getSecondName())));
	    response.andExpect(MockMvcResultMatchers.jsonPath("$.user.firstLastName", CoreMatchers.is(travelRequest.getUser().getFirstLastName())));
	    response.andExpect(MockMvcResultMatchers.jsonPath("$.user.secondLastName", CoreMatchers.is(travelRequest.getUser().getSecondLastName())));
	    response.andExpect(MockMvcResultMatchers.jsonPath("$.user.role", CoreMatchers.is(travelRequest.getUser().getRole())));
	    response.andExpect(MockMvcResultMatchers.jsonPath("$.type", CoreMatchers.is(travelRequest.getType())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.place", CoreMatchers.is(travelRequest.getPlace())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.motive", CoreMatchers.is(travelRequest.getMotive())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.activity", CoreMatchers.is(travelRequest.getActivity())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.job", CoreMatchers.is(travelRequest.getJob())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.modality", CoreMatchers.is(travelRequest.getModality())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.serie", CoreMatchers.is(travelRequest.getSerie())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.insuranceFirstName", CoreMatchers.is(travelRequest.getInsuranceFirstName())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.insuranceSecondName", CoreMatchers.is(travelRequest.getInsuranceSecondName())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.insuranceFirstLastName", CoreMatchers.is(travelRequest.getInsuranceFirstLastName())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.insuranceSecondLastName", CoreMatchers.is(travelRequest.getInsuranceSecondLastName())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.insuranceKinship", CoreMatchers.is(travelRequest.getInsuranceKinship())));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.totalPrice").value(travelRequest.getTotalPrice()));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.startDateRequest", CoreMatchers.is(getFormatDate(travelRequest.getStartDateRequest()))));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.endDateRequest", CoreMatchers.is(getFormatDate(travelRequest.getEndDateRequest()))));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.startDateAbsence", CoreMatchers.is(getFormatDate(travelRequest.getStartDateAbsence()))));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.endDateAbsence", CoreMatchers.is(getFormatDate(travelRequest.getEndDateAbsence()))));
    }

    private String getFormatDate(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("dd-MM-YYYY").format(localDateTime);
    }

    @Test
    void createTravelRequest_WhenRequestHasNonCompliantFields_ReturnBadRequest() throws Exception{
        when(travelRequestService.createTravelRequest(any())).thenReturn(travelRequest);

        ResultActions response = mockMvc.perform(post(baseUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(nonCompliantCreateRequestDTO)));

        response.andDo(print());
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}

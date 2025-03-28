package com.iim.service.persistency.api.controller;

import com.iim.service.persistency.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistency.api.entity.TravelRequest;
import com.iim.service.persistency.api.service.TravelRequestService;
import com.iim.service.persistency.util.TestDataFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@WebMvcTest(controllers = TravelRequestController.class)
@AutoConfigureMockMvc
public class TravelRequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TravelRequestService travelRequestService;

    private static CreateTravelRequestDTO compliantCreateRequestDTO;

    private static TravelRequest travelRequest;

    @BeforeAll
    static void init() {
        compliantCreateRequestDTO = TestDataFactory.buildCompliantCreateTravelRequestDto();
        travelRequest = TestDataFactory.buildTravelRequest();
    }

    @Test
    void createTravelRequest_WhenItCompliesAllConstraints_ReturnedTravelRequest() {
        when(travelRequestService.createTravelRequest(any())).thenReturn(travelRequest);
    }

}

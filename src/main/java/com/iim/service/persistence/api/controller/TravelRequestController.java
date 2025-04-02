package com.iim.service.persistence.api.controller;

import com.iim.service.persistence.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistence.api.entity.TravelRequest;
import com.iim.service.persistence.api.service.TravelRequestService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import static com.iim.service.persistence.api.constant.Paths.baseUrl;

@RestController
@RequestMapping(baseUrl)
public class TravelRequestController {

    private final TravelRequestService travelRequestService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TravelRequestController.class);

    @Autowired
    private TravelRequestController(TravelRequestService travelRequestService) {
        this.travelRequestService = travelRequestService;
    }

    @PostMapping
    public ResponseEntity<?> createTravelRequest(@Valid @RequestBody CreateTravelRequestDTO createTravelRequestDTO, BindingResult bindingResult) {
        LOGGER.info("Start Persistence Service");
        LOGGER.info("Received Request Body: {}", createTravelRequestDTO);

        if (bindingResult.hasErrors()) {
            LOGGER.error("Errors! : {}", bindingResult.getAllErrors());
            List<String> errorMessages = bindingResult.getAllErrors().stream().
                    map(ObjectError::getDefaultMessage).
                    toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }

        TravelRequest travelRequest = travelRequestService.createTravelRequest(createTravelRequestDTO);

        LOGGER.info("Created travel request: {}", travelRequest);
        return ResponseEntity.ok().
                contentType(MediaType.APPLICATION_JSON).
                location(URI.create(baseUrl + "/" + travelRequest.getId())).
                body(travelRequest);
    }
}


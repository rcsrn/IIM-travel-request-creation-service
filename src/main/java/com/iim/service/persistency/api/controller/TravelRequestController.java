package com.iim.service.persistency.api.controller;

import com.iim.service.persistency.api.dto.CreateTravelRequestDTO;
import com.iim.service.persistency.api.entity.TravelRequest;
import com.iim.service.persistency.api.service.TravelRequestService;
import jakarta.validation.Valid;
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

import static com.iim.service.persistency.api.constant.Paths.baseUrl;

@RestController
@RequestMapping(baseUrl)
public class TravelRequestController {

    private final TravelRequestService travelRequestService;

    @Autowired
    private TravelRequestController(TravelRequestService travelRequestService) {
        this.travelRequestService = travelRequestService;
    }

    @PostMapping
    public ResponseEntity<?> createTravelRequest(@RequestBody @Valid CreateTravelRequestDTO createTravelRequestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getAllErrors().stream().
                    map(ObjectError::getDefaultMessage).
                    toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }

        TravelRequest travelRequest = travelRequestService.createTravelRequest(createTravelRequestDTO);
        return ResponseEntity.ok().
                contentType(MediaType.APPLICATION_JSON).
                location(URI.create(baseUrl + "/" + travelRequest.getId())).
                body(travelRequest);
    }
}


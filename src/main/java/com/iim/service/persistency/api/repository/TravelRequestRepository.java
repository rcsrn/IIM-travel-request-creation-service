package com.iim.service.persistency.api.repository;


import com.iim.service.persistency.api.entity.TravelRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRequestRepository extends JpaRepository<TravelRequest, Long> {
}

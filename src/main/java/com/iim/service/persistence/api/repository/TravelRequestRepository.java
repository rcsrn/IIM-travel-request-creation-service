package com.iim.service.persistence.api.repository;


import com.iim.service.persistence.api.entity.TravelRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRequestRepository extends JpaRepository<TravelRequest, Long> {
}

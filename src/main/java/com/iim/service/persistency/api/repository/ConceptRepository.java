package com.iim.service.persistency.api.repository;


import com.iim.service.persistency.api.entity.Concept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConceptRepository extends JpaRepository<Concept, Long> {
}

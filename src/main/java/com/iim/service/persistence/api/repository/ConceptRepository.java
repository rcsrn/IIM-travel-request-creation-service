package com.iim.service.persistence.api.repository;


import com.iim.service.persistence.api.entity.Concept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptRepository extends JpaRepository<Concept, Long> {
}

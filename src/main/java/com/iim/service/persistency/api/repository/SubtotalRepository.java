package com.iim.service.persistency.api.repository;

import com.iim.service.persistency.api.entity.Subtotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtotalRepository extends JpaRepository<Subtotal, Long> {
}

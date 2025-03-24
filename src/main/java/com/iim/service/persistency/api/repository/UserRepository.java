package com.iim.service.persistency.api.repository;

import com.iim.service.persistency.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

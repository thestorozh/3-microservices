package com.storozh.middlenameservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.storozh.middlenameservice.model.MiddleName;

public interface MiddleNameRepository extends JpaRepository<MiddleName, String> {
    Optional<MiddleName> findById(Long id);
}
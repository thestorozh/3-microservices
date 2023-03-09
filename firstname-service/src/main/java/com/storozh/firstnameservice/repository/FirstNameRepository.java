package com.storozh.firstnameservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.storozh.firstnameservice.model.FirstName;

public interface FirstNameRepository extends JpaRepository<FirstName, String> {
    Optional<FirstName> findById(Long id);
}
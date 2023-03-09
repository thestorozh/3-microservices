package com.storozh.lastnameservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.storozh.lastnameservice.model.LastName;

public interface LastNameRepository extends JpaRepository<LastName, String> {
    Optional<LastName> findById(Long id);
}
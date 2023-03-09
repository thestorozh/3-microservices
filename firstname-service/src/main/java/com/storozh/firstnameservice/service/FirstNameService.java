package com.storozh.firstnameservice.service;

import com.storozh.firstnameservice.DTO.FirstNameDTO;
import com.storozh.firstnameservice.model.FirstName;
import com.storozh.firstnameservice.repository.FirstNameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FirstNameService {

    private static final Logger LOG = LoggerFactory.getLogger(FirstNameService.class);

    @Autowired
    private FirstNameRepository firstnameRepository;

    public FirstName createFirstName(FirstNameDTO firstnameDTO) {
        FirstName firstname = new FirstName(firstnameDTO.getFirstname());
        LOG.info("Firstname with ID {} is created", firstname.getId());
        return firstnameRepository.save(new FirstName(firstnameDTO.getFirstname()));

    }
    public List<FirstName> getAllFirstNames() {
        return firstnameRepository.findAll();
    }
    
    public FirstName updateFirstName(Long id, FirstNameDTO firstnameDTO) {
        Optional<FirstName> optionalFirstName = firstnameRepository.findById(id);
        if (optionalFirstName.isPresent()) {
            FirstName firstname = optionalFirstName.get();
            firstname = firstname.toBuilder()
                .firstname(firstnameDTO.getFirstname())
                .build();
            firstname = firstnameRepository.save(firstname);
            LOG.info("Firstname with ID {} is updated", id);
            return firstname;
        } else {
            return null;
        }
    }

    public boolean deleteFirstNameById(Long id) {
        Optional<FirstName> optionalFirstName = firstnameRepository.findById(id);
        if (optionalFirstName.isPresent()) {
            FirstName firstname = optionalFirstName.get();
            firstnameRepository.delete(firstname);
            LOG.info("Firstname with ID {} deleted successfully", id);
            return true;
        } else {
            return false;
        }
    }
}
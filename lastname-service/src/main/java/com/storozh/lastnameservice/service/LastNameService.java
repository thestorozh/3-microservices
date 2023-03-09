package com.storozh.lastnameservice.service;

import com.storozh.lastnameservice.DTO.LastNameDTO;
import com.storozh.lastnameservice.model.LastName;
import com.storozh.lastnameservice.repository.LastNameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LastNameService {

    private static final Logger LOG = LoggerFactory.getLogger(LastNameService.class);

    @Autowired
    private LastNameRepository lastnameRepository;

    public LastName createLastName(LastNameDTO lastnameDTO) {
        LastName lastname = new LastName(lastnameDTO.getLastname());
        LOG.info("Lastname with ID {} is created", lastname.getId());
        return lastnameRepository.save(new LastName(lastnameDTO.getLastname()));

    }
    public List<LastName> getAllLastNames() {
        return lastnameRepository.findAll();
    }
    
    public LastName updateLastName(Long id, LastNameDTO lastnameDTO) {
        Optional<LastName> optionalLastName = lastnameRepository.findById(id);
        if (optionalLastName.isPresent()) {
            LastName lastname = optionalLastName.get();
            lastname = lastname.toBuilder()
                .lastname(lastnameDTO.getLastname())
                .build();
            lastname = lastnameRepository.save(lastname);
            LOG.info("Lastname with ID {} is updated", id);
            return lastname;
        } else {
            return null;
        }
    }

    public boolean deleteLastNameById(Long id) {
        Optional<LastName> optionalLastName = lastnameRepository.findById(id);
        if (optionalLastName.isPresent()) {
            LastName lastname = optionalLastName.get();
            lastnameRepository.delete(lastname);
            LOG.info("Lastname with ID {} deleted successfully", id);
            return true;
        } else {
            return false;
        }
    }
}
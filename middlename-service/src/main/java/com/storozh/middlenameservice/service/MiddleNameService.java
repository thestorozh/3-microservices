package com.storozh.middlenameservice.service;

import com.storozh.middlenameservice.DTO.MiddleNameDTO;
import com.storozh.middlenameservice.model.MiddleName;
import com.storozh.middlenameservice.repository.MiddleNameRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MiddleNameService {

    private static final Logger LOG = LoggerFactory.getLogger(MiddleNameService.class);

    @Autowired
    private MiddleNameRepository middlenameRepository;

    public MiddleName createMiddleName(MiddleNameDTO middlenameDTO) {
        MiddleName middlename = new MiddleName(middlenameDTO.getMiddlename());
        LOG.info("Middlename with ID {} is created", middlename.getId());
        return middlenameRepository.save(new MiddleName(middlenameDTO.getMiddlename()));

    }
    public List<MiddleName> getAllMiddleNames() {
        return middlenameRepository.findAll();
    }
    
    public MiddleName updateMiddleName(Long id, MiddleNameDTO middlenameDTO) {
        Optional<MiddleName> optionalMiddleName = middlenameRepository.findById(id);
        if (optionalMiddleName.isPresent()) {
            MiddleName middlename = optionalMiddleName.get();
            middlename = middlename.toBuilder()
                .middlename(middlenameDTO.getMiddlename())
                .build();
            middlename = middlenameRepository.save(middlename);
            LOG.info("Middlename with ID {} is updated", id);
            return middlename;
        } else {
            return null;
        }
    }

    public boolean deleteMiddleNameById(Long id) {
        Optional<MiddleName> optionalMiddleName = middlenameRepository.findById(id);
        if (optionalMiddleName.isPresent()) {
            MiddleName middlename = optionalMiddleName.get();
            middlenameRepository.delete(middlename);
            LOG.info("Middlename with ID {} deleted successfully", id);
            return true;
        } else {
            return false;
        }
    }
}
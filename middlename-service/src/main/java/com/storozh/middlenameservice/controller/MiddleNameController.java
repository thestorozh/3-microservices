package com.storozh.middlenameservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.storozh.middlenameservice.DTO.MiddleNameDTO;
import com.storozh.middlenameservice.model.MiddleName;
import com.storozh.middlenameservice.service.MiddleNameService;

import java.util.List;

@RestController
@RequestMapping("/api/middlename")
public class MiddleNameController {

    @Autowired
    MiddleNameService middlenameService;

    @PostMapping
    public MiddleName create(@RequestBody  MiddleNameDTO middlenameDTO) {
        MiddleName middlename = middlenameService.createMiddleName(middlenameDTO);
        return middlename;
    }

    @GetMapping
    public List<MiddleName> getAllMiddleNames() {
        return middlenameService.getAllMiddleNames();
    }

    @PutMapping("/update/{id}")
    public MiddleName updateMiddleName(@PathVariable Long id, @RequestBody MiddleNameDTO middlenameDTO) {
        MiddleName middlename = middlenameService.updateMiddleName(id, middlenameDTO);
        if (middlename == null) {
            throw new RuntimeException("MiddleName not found with id " + id);
        }
        return middlename;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMiddleNameById(@PathVariable Long id) {
        boolean success = middlenameService.deleteMiddleNameById(id);
        if (success) {
            return ResponseEntity.ok("MiddleName with ID " + id + " deleted successfully");
        } else {
            throw new RuntimeException("MiddleName not found with id " + id);
        }
    }
}
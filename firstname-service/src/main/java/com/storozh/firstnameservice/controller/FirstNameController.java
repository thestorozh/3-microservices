package com.storozh.firstnameservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.storozh.firstnameservice.DTO.FirstNameDTO;
import com.storozh.firstnameservice.model.FirstName;
import java.util.List;
import com.storozh.firstnameservice.service.FirstNameService;

@RestController
@RequestMapping("/api/firstname")
public class FirstNameController {

    @Autowired
    FirstNameService firstnameService;

    @PostMapping
    public FirstName create(@RequestBody  FirstNameDTO firstnameDTO) {
        FirstName firstname = firstnameService.createFirstName(firstnameDTO);
        return firstname;
    }

    @GetMapping
    public List<FirstName> getAllFirstNames() {
        return firstnameService.getAllFirstNames();
    }

    @PutMapping("/update/{id}")
    public FirstName updateFirstName(@PathVariable Long id, @RequestBody FirstNameDTO firstnameDTO) {
        FirstName firstname = firstnameService.updateFirstName(id, firstnameDTO);
        if (firstname == null) {
            throw new RuntimeException("FirstName not found with id " + id);
        }
        return firstname;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFirstNameById(@PathVariable Long id) {
        boolean success = firstnameService.deleteFirstNameById(id);
        if (success) {
            return ResponseEntity.ok("FirstName with ID " + id + " deleted successfully");
        } else {
            throw new RuntimeException("FirstName not found with id " + id);
        }
    }
}
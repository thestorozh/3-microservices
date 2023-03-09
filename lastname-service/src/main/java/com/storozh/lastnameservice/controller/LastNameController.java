package com.storozh.lastnameservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.storozh.lastnameservice.DTO.LastNameDTO;
import com.storozh.lastnameservice.model.LastName;
import java.util.List;
import com.storozh.lastnameservice.service.LastNameService;

@RestController
@RequestMapping("/api/lastname")
public class LastNameController {

    @Autowired
    LastNameService lastnameService;

    @PostMapping
    public LastName create(@RequestBody  LastNameDTO lastnameDTO) {
        LastName lastname = lastnameService.createLastName(lastnameDTO);
        return lastname;
    }

    @GetMapping
    public List<LastName> getAllLastNames() {
        return lastnameService.getAllLastNames();
    }

    @PutMapping("/update/{id}")
    public LastName updateLastName(@PathVariable Long id, @RequestBody LastNameDTO lastnameDTO) {
        LastName lastname = lastnameService.updateLastName(id, lastnameDTO);
        if (lastname == null) {
            throw new RuntimeException("LastName not found with id " + id);
        }
        return lastname;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLastNameById(@PathVariable Long id) {
        boolean success = lastnameService.deleteLastNameById(id);
        if (success) {
            return ResponseEntity.ok("LastName with ID " + id + " deleted successfully");
        } else {
            throw new RuntimeException("LastName not found with id " + id);
        }
    }
}
package com.storozh.firstnameservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Builder(toBuilder = true)
@AllArgsConstructor
@Data
@Entity
@Table(name = "firstname")
public class FirstName implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private String firstname;

    public FirstName() {
        // default constructor
    }

    public FirstName(String firstname) {
        this.firstname = firstname;
    }
}
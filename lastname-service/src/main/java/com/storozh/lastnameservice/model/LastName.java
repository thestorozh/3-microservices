package com.storozh.lastnameservice.model;

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
@Table(name = "lastname")
public class LastName implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "lastname")
    private String lastname;

    public LastName() {
        // default constructor
    }

    public LastName(String lastname) {
        this.lastname = lastname;
    }
}
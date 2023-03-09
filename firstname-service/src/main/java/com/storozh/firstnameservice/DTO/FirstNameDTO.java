package com.storozh.firstnameservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FirstNameDTO {
    private Long id;
    private String firstname;
}
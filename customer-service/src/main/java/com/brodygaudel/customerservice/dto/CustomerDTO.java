package com.brodygaudel.customerservice.dto;

import java.util.Date;

public record CustomerDTO(
        Long id,
        String firstname,
        String name,
        String placeOfBirth,
        Date dateOfBirth,
        String nationality,
        String cin,
        String email,
        String phone) {
}

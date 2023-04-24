package com.sofka.agenda.dto;

import com.sofka.agenda.models.Contacto;
import lombok.Data;

@Data
public class PhoneDto {

    private Long id;
    private String brand;
    private String operator;
    private String number;
    private Contacto contact;
}

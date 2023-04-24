package com.sofka.agenda.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "contactos")
@Data
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contacto_id", nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "num_telefono")
    private String numberPhone;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_nacimiento")
    private String birthDate;

    public Contacto() {

    }

}

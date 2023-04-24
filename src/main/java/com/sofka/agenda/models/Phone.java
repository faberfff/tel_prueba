package com.sofka.agenda.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "telefono")
@Data
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "telefono_id")
    private Long id;

    @Column(name = "marca")
    private String brand;

    @Column(name = "operador")
    private String operator;

    @Column(name = "numero")
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "contactos_contacto_id")
    private Contacto contact;

    public Phone() {

    }
}

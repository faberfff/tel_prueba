package com.sofka.agenda.controller;

import com.sofka.agenda.dto.ContactoDto;
import com.sofka.agenda.exception.RestException;
import com.sofka.agenda.models.Contacto;
import com.sofka.agenda.service.iface.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contactos")
public class ContactoController {

    @Autowired(required = false)
    private IContactoService contactoService;


    @PostMapping("/crear")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Contacto create(@RequestBody Contacto contacto){
        //Contacto contactoCreate = contactoService.createContacto(contacto);
        return contactoService.createContacto(contacto);
       // ResponseEntity.status(HttpStatus.CREATED).body(contactoCreate);
    }

    @GetMapping("/listar")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<ContactoDto>> index() throws RestException {
        List<ContactoDto> contactosDto = contactoService.findAll();
        return ResponseEntity.ok().body(contactosDto);
    }




}

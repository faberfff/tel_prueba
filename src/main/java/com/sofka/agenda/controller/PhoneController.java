package com.sofka.agenda.controller;


import com.sofka.agenda.exception.RestException;
import com.sofka.agenda.models.Phone;
import com.sofka.agenda.service.iface.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/")
public class PhoneController {

    @Autowired(required = false)
    private IPhoneService phoneService;

    @PostMapping("/crear")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) throws RestException {
        Phone phoneCreate = phoneService.createPhone(phone);
        return ResponseEntity.status(HttpStatus.CREATED).body(phoneCreate);
    }
}

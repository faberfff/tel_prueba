package com.sofka.agenda.service.iface;

import com.sofka.agenda.dto.PhoneDto;
import com.sofka.agenda.exception.RestException;
import com.sofka.agenda.models.Phone;

import java.util.List;

public interface IPhoneService {

    public Phone createPhone(Phone phone) throws RestException;

    public Phone updatePhone(Phone phone) throws RestException;

    public void deletePhone(Long id) throws RestException;

    public Phone findById(Long id) throws RestException;

    public List<PhoneDto> findAll();

}

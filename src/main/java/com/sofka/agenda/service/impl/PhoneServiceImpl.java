package com.sofka.agenda.service.impl;

import com.sofka.agenda.dto.ContactoDto;
import com.sofka.agenda.dto.PhoneDto;
import com.sofka.agenda.exception.BadRequestException;
import com.sofka.agenda.exception.ErrorDto;
import com.sofka.agenda.exception.NotFoundException;
import com.sofka.agenda.exception.RestException;
import com.sofka.agenda.models.Contacto;
import com.sofka.agenda.models.Phone;
import com.sofka.agenda.repository.IPhoneRepository;
import com.sofka.agenda.service.iface.IPhoneService;
import com.sofka.agenda.util.ConstUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PhoneServiceImpl implements IPhoneService {

    @Autowired
    private IPhoneRepository phoneRepo;


    @Transactional
    @Override
    public Phone createPhone(Phone phone) throws RestException {

        if(Objects.isNull(phone)) {
            throw new BadRequestException(ErrorDto.getErrorDto(HttpStatus.BAD_REQUEST.getReasonPhrase(),
                    ConstUtil.MESSAGE_BAD_REQUEST, HttpStatus.BAD_REQUEST.value()));
        }
        return phoneRepo.save(phone);
    }

    @Transactional
    @Override
    public Phone updatePhone(Phone phone) throws RestException {

        if(Objects.isNull(phone)) {
            throw new BadRequestException(ErrorDto.getErrorDto(HttpStatus.BAD_REQUEST.getReasonPhrase(),
                    ConstUtil.MESSAGE_BAD_REQUEST, HttpStatus.BAD_REQUEST.value()));
        }
        return phoneRepo.save(phone);
    }

    @Transactional
    @Override
    public void deletePhone(Long id) throws RestException {

        Optional<Phone> phone = phoneRepo.findById(id);
        if(phone.isPresent()) {
            phoneRepo.deleteById(id);
        }else {
            throw new NotFoundException(ErrorDto.getErrorDto(
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND,
                    HttpStatus.NOT_FOUND.value())
            );
        }

    }

    @Transactional
    @Override
    public Phone findById(Long id) throws RestException {
        Optional<Phone> phone = phoneRepo.findById(id);
        Phone phon = null;
        if(phone.isPresent()) {
            phon = phone.get();
        } else {
            throw new NotFoundException(ErrorDto.getErrorDto(HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND, HttpStatus.NOT_FOUND.value()));
        }
        return phon;
    }

    @Transactional
    @Override
    public List<PhoneDto> findAll() {
        List<Phone> phones = phoneRepo.findAll();
        List<PhoneDto> phonesDto = new ArrayList<>();

        phones.stream()
                .forEach(p -> {
                    PhoneDto phoneDto = new PhoneDto();
                    phoneDto.setId(p.getId());
                    phoneDto.setBrand(p.getBrand());
                    phoneDto.setOperator(p.getOperator());
                    phoneDto.setNumber(p.getNumber());
                    phoneDto.setContact(p.getContact());
                    phonesDto.add(phoneDto);
                });

        return phonesDto;
    }
}

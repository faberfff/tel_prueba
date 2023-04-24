package com.sofka.agenda.service.impl;

import com.sofka.agenda.dto.ContactoDto;
import com.sofka.agenda.exception.BadRequestException;
import com.sofka.agenda.exception.ErrorDto;
import com.sofka.agenda.exception.NotFoundException;
import com.sofka.agenda.exception.RestException;
import com.sofka.agenda.models.Contacto;
import com.sofka.agenda.repository.IContactoRepository;
import com.sofka.agenda.service.iface.IContactoService;
import com.sofka.agenda.util.ConstUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContactoServiceImpl implements IContactoService {

    @Autowired private IContactoRepository contactoRepo;

    @Transactional
    @Override
    public Contacto createContacto(Contacto contacto) {

        return contactoRepo.save(contacto);
    }

    @Transactional
    @Override
    public Contacto updateContacto(Contacto contacto) throws RestException {

        Contacto contactoBd = contactoRepo.getReferenceById(contacto.getId());
        if(Objects.nonNull(contacto)) {
            contactoBd.setId(contacto.getId());
            contactoBd.setName(contacto.getName());
            contactoBd.setNumberPhone(contacto.getNumberPhone());
            contactoBd.setEmail(contacto.getEmail());
            contactoBd.setBirthDate(contacto.getBirthDate());

        } else {
            throw new NotFoundException(ErrorDto.getErrorDto(HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND, HttpStatus.NOT_FOUND.value()));
        }
        return contactoRepo.save(contacto);
    }

    @Transactional
    @Override
    public void deleteContacto(Long id) throws RestException {
        Optional<Contacto> contacto = contactoRepo.findById(id);
        if(contacto.isPresent()) {
            contactoRepo.deleteById(id);
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
    public Contacto findById(Long id) throws RestException {
        return contactoRepo.findById(id).orElse(null);
    }

    @Override
    public List<ContactoDto> findAll() {
        List<Contacto> contactos = contactoRepo.findAll();
        List<ContactoDto> contactosDto = new ArrayList<>();

        contactos.stream()
                .forEach(c -> {
                   ContactoDto contactoDto = new ContactoDto();
                   contactoDto.setId(c.getId());
                   contactoDto.setName(c.getName());
                   contactoDto.setNumberPhone(c.getNumberPhone());
                   contactoDto.setEmail(c.getEmail());
                   contactoDto.setNumberPhone(c.getNumberPhone());
                   contactosDto.add(contactoDto);
                });
        return contactosDto;
    }
}

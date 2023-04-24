package com.sofka.agenda.service.iface;

import com.sofka.agenda.dto.ContactoDto;
import com.sofka.agenda.exception.RestException;
import com.sofka.agenda.models.Contacto;

import java.util.List;

public interface IContactoService {

    /**
     * crea un contacto en el sistema
     * @param contacto
     * @return un objeto de contacto creado
     * @throws RestException
     *
     * @author Faber Fernández <faverfff@gmail.com>
     * @since 1.0.0
     */
    public Contacto createContacto(Contacto contacto);

    /**
     * Actualiza un contacto de la lista
     * @param contacto
     * @return contacto con nuevos valores
     * @throws RestException
     *
     * @author Faber Fernández <faverfff@gmail.com>
     * @since 1.0.0
     */
    public Contacto updateContacto(Contacto contacto) throws RestException;

    /**
     * Quita un contacto de la lista
     * @param id
     * @throws RestException
     *
     * @author Faber Fernández <faverfff@gmail.com>
     * @since 1.0.0
     */
    public void deleteContacto(Long id) throws RestException;

    /**
     * Busca un contacto por el parametro id
     * @param id
     * @return un contacto en específico
     * @throws RestException
     *
     * @author Faber Fernández <faverfff@gmail.com>
     * @since 1.0.0
     */
    public Contacto findById(Long id) throws  RestException;

    /**
     * Busca todos los contactos almacenados en el sistema
     * @return un listado de contactos
     *
     * @author Faber Fernández <faverfff@gmail.com>
     * @since 1.0.0
     */
    public List<ContactoDto> findAll();


}

package com.sofka.agenda.repository;

import com.sofka.agenda.models.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContactoRepository extends JpaRepository<Contacto, Long> {


    /**
     * Busca los contactos que empizan por X dato tanto por nombre como por apellido
     *
     * @param data Dato a buscar
     * @return Listado de contactos encontrados
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    @Query(value = "SELECT cnt " +
            "FROM Contacto cnt " +
            "WHERE (cnt.name LIKE :data%) " +
            "ORDER BY cnt.name ASC")
    public List<Contacto> findByNombreOrApellidoStartingWith(@Param("data") String data);

}

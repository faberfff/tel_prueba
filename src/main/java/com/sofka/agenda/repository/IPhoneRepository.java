package com.sofka.agenda.repository;

import com.sofka.agenda.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone, Long> {

}

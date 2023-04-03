package com.example.mspersona.domain.repositories;

import com.example.mspersona.domain.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query(value = "select p from Persona p where p.name=?1")
    List<Persona> findPersonasByName(String name);
}

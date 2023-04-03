package com.example.msbasededatos.domain.repositories;

import com.example.msbasededatos.domain.models.BaseDeDatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDeDatosRepository extends JpaRepository<BaseDeDatos, Long> {

    @Query(value = "select b from BaseDeDatos b where b.name=?1")
    List<BaseDeDatos> findBaseByName(String name);
}

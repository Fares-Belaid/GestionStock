package com.fares.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fares.gestiondestock.model.Ventes;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

}

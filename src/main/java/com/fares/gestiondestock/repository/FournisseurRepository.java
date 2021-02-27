package com.fares.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fares.gestiondestock.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

}

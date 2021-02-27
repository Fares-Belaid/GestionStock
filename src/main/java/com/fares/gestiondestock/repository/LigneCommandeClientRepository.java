package com.fares.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fares.gestiondestock.model.LigneCommandeClient;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {

}

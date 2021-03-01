package com.fares.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fares.gestiondestock.model.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

	Optional <CommandeClient> findCommandeByCode(String code);
	
}

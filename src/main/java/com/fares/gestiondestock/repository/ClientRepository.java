package com.fares.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fares.gestiondestock.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}

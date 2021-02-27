package com.fares.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fares.gestiondestock.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

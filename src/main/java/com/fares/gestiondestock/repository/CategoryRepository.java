package com.fares.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fares.gestiondestock.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Optional <Category> findCategoryByCode(String codeCategory);
}

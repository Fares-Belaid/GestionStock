package com.fares.gestiondestock.services;

import java.util.List;

import com.fares.gestiondestock.dto.CategoryDto;


public interface CategoryService {

	CategoryDto save(CategoryDto dto);

	CategoryDto findById(Integer id);

	CategoryDto findByCodeCategory(String codeCategory);

	List<CategoryDto> findAll();
	
	void delete(Integer id);
}

package com.fares.gestiondestock.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fares.gestiondestock.dto.CategoryDto;
import com.fares.gestiondestock.exception.EntityNotFoundException;
import com.fares.gestiondestock.exception.ErrorCodes;
import com.fares.gestiondestock.exception.InvalidEntityException;
import com.fares.gestiondestock.model.Category;
import com.fares.gestiondestock.repository.CategoryRepository;
import com.fares.gestiondestock.services.CategoryService;
import com.fares.gestiondestock.validator.CategoryValidator;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public CategoryDto save(CategoryDto dto) {
		List<String> errors = CategoryValidator.validate(dto);

		if (!errors.isEmpty()) {
			log.error("Category is not valid {}",dto);
			throw new InvalidEntityException("La category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID,errors);
		}
		return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(dto)));
	}

	@Override
	public CategoryDto findById(Integer id) {
		if (id == null) {
			log.error("Category id is null");
			return null;
		}
		Optional <Category> category = categoryRepository.findById(id);
		
		CategoryDto dto = CategoryDto.fromEntity(category.get());
		
		return Optional.of(dto).orElseThrow(() ->
			new EntityNotFoundException(
					"Aucun Category avec l'id = "+ id + " n'ete touve dans la BD",
					ErrorCodes.CATEGORY_NOT_FOUND));
	}

	
	@Override
	public CategoryDto findByCodeCategory(String codeCategory) {
		if (!StringUtils.hasLength(codeCategory)) {
			log.error("Category code is null");
			return null;
		}
		return categoryRepository.findCategoryByCode(codeCategory).map(CategoryDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun category avec le code = " + codeCategory + " n'ete touve dans la BD",
						ErrorCodes.CATEGORY_NOT_FOUND));

	}

	@Override
	public List<CategoryDto> findAll() {
		return categoryRepository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Category id is null");
			return ;
		}
		categoryRepository.deleteById(id);
	}


	

}

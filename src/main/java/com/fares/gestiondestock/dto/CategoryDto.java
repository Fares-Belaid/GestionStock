package com.fares.gestiondestock.dto;

import java.util.List;



import com.fares.gestiondestock.model.Article;
import com.fares.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder					// yasna3 des objets de type ela nheb 3lih (exp lena de type CategoryDto)
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDto {


	private Integer id;

	private String codeCategory;
	
	private String designation;
	
	private Integer idEntrprise;

	@JsonIgnore
	private List<ArticleDto> articles ;
	

	
	public static CategoryDto fromEntity(Category category) {
		if(category == null) {
			return null;
			//TODO throw an Exception 
			
		}
	
		return CategoryDto.builder()
				.id(category.getId())
				.codeCategory(category.getCodeCategory())
				.designation(category.getDesignation())
				.build();
	}
	
	
	public static Category toEntity(CategoryDto categoryDto) {
		if(categoryDto == null) {
			return null;
			//TODO throw an Exception 
			
		}
	
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setCodeCategory(categoryDto.getCodeCategory());
		category.setDesignation(categoryDto.getDesignation());
		return category;
	}
}

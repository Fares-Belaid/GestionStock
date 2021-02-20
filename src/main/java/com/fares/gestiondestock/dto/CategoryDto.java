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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {


	private Integer id;

	private String codeCategory;
	

	private String designation;
	
	@JsonIgnore
	private List<ArticleDto> articles ;
	

	
	public CategoryDto fromEntity(Category category) {
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
	
	
	public Category toEntity(CategoryDto categoryDto) {
		if(categoryDto == null) {
			return null;
			//TODO throw an Exception 
			
		}
	
		return Category.builder()
				.codeCategory(categoryDto.getCodeCategory())
				.designation(categoryDto.getDesignation())
				.build();
	}
}

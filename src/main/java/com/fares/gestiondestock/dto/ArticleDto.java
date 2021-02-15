package com.fares.gestiondestock.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fares.gestiondestock.model.Category;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArticleDto {

	private Integer id;


	private String codeArticle;
	

	private String designation;
	

	private BigDecimal prixUnitaireht;
	

	private BigDecimal tauxTva;
	

	private BigDecimal prixUnitaireTtc;
	

	private String photo;

	private CategoryDto category ;
}

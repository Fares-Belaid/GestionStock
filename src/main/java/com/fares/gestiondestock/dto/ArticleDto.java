package com.fares.gestiondestock.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fares.gestiondestock.model.Article;
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
	
	public static ArticleDto fromEntity(Article article) {
		if (article == null) {
			return null;
		}
		
		return ArticleDto.builder()
				.id(article.getId())
				.codeArticle(article.getCodeArticle())
				.designation(article.getDesignation())
				.prixUnitaireht(article.getPrixUnitaireht())
				.tauxTva(article.getTauxTva())
				.prixUnitaireTtc(article.getPrixUnitaireTtc())
				.photo(article.getPhoto())
				.build();
	}
	
	public static Article toEntity(ArticleDto articleDto) {
		if(articleDto == null) {
			return null;
			//TODO throw an Exception 
			
		}
	
		Article article = new Article();
		article.setId(articleDto.getId());
		article.setCodeArticle(articleDto.getCodeArticle());
		article.setDesignation(articleDto.getDesignation());
		article.setPrixUnitaireht(articleDto.getPrixUnitaireht());
		article.setTauxTva(articleDto.getTauxTva());
		article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
		article.setPhoto(articleDto.getPhoto());
		return article;
	}
}

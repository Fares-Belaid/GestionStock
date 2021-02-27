package com.fares.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fares.gestiondestock.dto.ArticleDto;

public class ArticleValidator {

	public static List<String> validate(ArticleDto articleDto){
		 List<String> errors = new ArrayList<>();
		 
		 if (articleDto == null || !StringUtils.hasLength(articleDto.getCodeArticle())) {
			errors.add("Veuillez renseigner le code de l'article");
		}
		 if (articleDto == null || !StringUtils.hasLength(articleDto.getDesignation())) {
				errors.add("Veuillez renseigner la designation de l'article");
			}	
		 if (articleDto == null || articleDto.getPrixUnitaireht() == null) {
				errors.add("Veuillez renseigner le prix unitaire de l'article");
			}	
		 if (articleDto == null ||articleDto.getTauxTva() == null) {
				errors.add("Veuillez renseigner le taux TVA de l'article");
			}	
		 if (articleDto == null || articleDto.getCategory() == null) {
				errors.add("Veuillez renseigner la categorie de l'article");
			}	
		 if (articleDto == null ||articleDto.getPrixUnitaireTtc() == null) {
				errors.add("Veuillez renseigner le prix TTC de l'article");
			}
		 return errors ;
	}
}

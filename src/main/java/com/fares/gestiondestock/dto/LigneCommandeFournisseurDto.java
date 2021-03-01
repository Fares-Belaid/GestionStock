package com.fares.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {

	private Integer id;

	private ArticleDto article;
	
	private Integer idEntrprise;

	private CommandeFournisseurDto commandefournisseur; 
}

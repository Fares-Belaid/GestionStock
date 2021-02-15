package com.fares.gestiondestock.dto;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {

	private Integer id;

	
	private ArticleDto article;
	

	private CommandeClientDto commandeclient; 
}

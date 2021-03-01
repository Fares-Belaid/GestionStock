package com.fares.gestiondestock.dto;



import com.fares.gestiondestock.model.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {

	private Integer id;

	private Integer idEntrprise;

	
	private ArticleDto article;
	

	private CommandeClientDto commandeclient; 
	
	public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientdto) {
		if(ligneCommandeClientdto == null) {
			return null;
			//TODO throw an Exception 
			
		}
		LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
		ligneCommandeClient.setId(ligneCommandeClient.getId());
		ligneCommandeClient.setArticle(ligneCommandeClient.getArticle());
		return ligneCommandeClient;
	}
}

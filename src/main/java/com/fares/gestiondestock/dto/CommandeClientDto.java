package com.fares.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.fares.gestiondestock.model.Article;
import com.fares.gestiondestock.model.Category;
import com.fares.gestiondestock.model.CommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {


	private Integer id;

	private String code;
	
	private Integer idEntrprise;


	private Instant dateCommande;

	private ClientDto client;
	

	private List<LigneCommandeClientDto> ligneCommandeClient;
	
	public static CommandeClient toEntity(CommandeClientDto commandeClientdto) {
		if(commandeClientdto == null) {
			return null;
			//TODO throw an Exception 
			
		}
		CommandeClient commandeClient = new CommandeClient();
		commandeClient.setId(commandeClientdto.getId());
		commandeClient.setCode(commandeClientdto.getCode());
		// ........
		// TODO the rest of the attributs
		return commandeClient;
	}
	
	public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
		if(commandeClient == null) {
			return null;
			//TODO throw an Exception 
			
		}
	
		return CommandeClientDto.builder()
				.id(commandeClient.getId())
				.code(commandeClient.getCode())
			// ................
			// TODO the rest of attributs
			
				.build();
	}
	
}
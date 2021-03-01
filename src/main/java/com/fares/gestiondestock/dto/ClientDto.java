package com.fares.gestiondestock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDto {


	private Integer id;

	private String nom ;
	
	private String prenom ;
	
	private AdresseDto adresse ;
	
	private String photo ;
	
	private String email ;

	private Integer idEntrprise;

	private String numTel ;
	@JsonIgnore
	private List<CommandeClientDto> commandeClients;
	

}

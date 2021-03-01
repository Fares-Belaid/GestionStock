package com.fares.gestiondestock.dto;

import com.fares.gestiondestock.model.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {

	private Integer id;

	private String roleName;
	
	private Integer idEntrprise;

	private UtilisateurDto utilisateur;

}

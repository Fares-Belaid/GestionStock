package com.fares.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fares.gestiondestock.dto.UtilisateurDto;


public class UtilisateurValidator {

	public static List<String> validate(UtilisateurDto utilisateurDto){
		 List<String> errors = new ArrayList<>();
		 
		 if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getNom())) {
			errors.add("Veuillez renseigner le nom de l'utilisateur");
		}
		 if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom de l'utilisateur");
		}
		 if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getEmail())) {
			errors.add("Veuillez renseigner l'email de l'utilisateur");
		}
		 if (utilisateurDto == null ||utilisateurDto.getDateDeNaissance() == null) {
			errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
		}
		 if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
			errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
		}
		 if (utilisateurDto == null || utilisateurDto.getEntreprise() == null) {
			errors.add("Veuillez renseigner l'entreprise de l'utilisateur");
		}
		 if (utilisateurDto == null || utilisateurDto.getRoles() == null) {
				errors.add("Veuillez renseigner le role de l'utilisateur");
			}
		 return errors ;
	}
}

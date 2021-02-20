package com.fares.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fares.gestiondestock.dto.CategoryDto;
import com.fares.gestiondestock.dto.UtilisateurDto;

public class UtilsateurValidator {

	public static List<String> validate(UtilisateurDto utilisateurDto ){
		 List<String> errors = new ArrayList<>();
		 
		 if (utilisateurDto == null) {
			 errors.add("Veuillez renseigner le nom");
			 errors.add("Veuillez renseigner le prenom");
			 errors.add("Veuillez renseigner l'email");
			 errors.add("Veuillez renseigner le mot de passe");
			 errors.add("Veuillez renseigner la date de naissance");
			 errors.add("Veuillez renseigner l'adresse ");
		}
		 
		 if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getNom())) {
			errors.add("Veuillez renseigner le nom");
		}
		 if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom");
		}
		 if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getEmail())) {
			errors.add("Veuillez renseigner l'email");
			}
		 if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
			errors.add("Veuillez renseigner le mot de passe");
		}
		 if (utilisateurDto == null) {
			 errors.add("Veuillez renseigner la date de naissance");
		}
		 if (utilisateurDto.getAdresse() == null ) {
			errors.add("Veuillez renseigner l'adresse ");
		}else {
			 if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
				errors.add("le champs adresse 1 est obligatoire");
			}
			 if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
					errors.add("le champs ville est obligatoire");
				}
			 if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
				errors.add("le champs ville est obligatoire");
			}
			 if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
					errors.add("le champs pays est obligatoire");
				}
		}
		 return errors ;
	}
}

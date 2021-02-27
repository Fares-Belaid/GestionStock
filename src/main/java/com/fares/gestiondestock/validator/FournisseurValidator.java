package com.fares.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fares.gestiondestock.dto.FournisseurDto;



public class FournisseurValidator {

	public static List<String> validate(FournisseurDto fournisseurDto){
		 List<String> errors = new ArrayList<>();
		 
		 if (fournisseurDto == null || !StringUtils.hasLength(fournisseurDto.getNom())) {
			errors.add("Veuillez renseigner le nom du client");
		}
		 if (fournisseurDto == null || !StringUtils.hasLength(fournisseurDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom du client");
		}
		 if (fournisseurDto == null || !StringUtils.hasLength(fournisseurDto.getEmail())) {
			errors.add("Veuillez renseigner l'email du client");
		}
		 if (fournisseurDto == null || !StringUtils.hasLength(fournisseurDto.getNumTel())) {
			errors.add("Veuillez renseigner le num de telephone");
		}

		 return errors ;
	}
}

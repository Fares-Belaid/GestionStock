package com.fares.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fares.gestiondestock.dto.EntrepriseDto;


public class EntrepriseValidator {

	public static List<String> validate(EntrepriseDto entrepriseDto){
		 List<String> errors = new ArrayList<>();
		 
		 if (entrepriseDto == null || !StringUtils.hasLength(entrepriseDto.getNom())) {
			errors.add("Veuillez renseigner le nom de l'entreprise");
		}
		 return errors ;
	}
}

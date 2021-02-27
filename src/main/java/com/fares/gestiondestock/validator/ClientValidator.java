package com.fares.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fares.gestiondestock.dto.ClientDto;

public class ClientValidator {

	public static List<String> validate(ClientDto clientDto){
		 List<String> errors = new ArrayList<>();
		 
		 if (clientDto == null || !StringUtils.hasLength(clientDto.getNom())) {
			errors.add("Veuillez renseigner le nom du client");
		}
		 if (clientDto == null || !StringUtils.hasLength(clientDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom du client");
		}
		 if (clientDto == null || !StringUtils.hasLength(clientDto.getEmail())) {
			errors.add("Veuillez renseigner l'email du client");
		}
		 if (clientDto == null || !StringUtils.hasLength(clientDto.getNumTel())) {
			errors.add("Veuillez renseigner le num de telephone");
		}

		 return errors ;
	}
}

package com.fares.gestiondestock.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Embeddable						// ma3neha champs composé tnajem testa3mlou f barcha classet
public class Adresse {

	@Column(name = "adresse1")
	private String adresse1 ;
	
	@Column(name = "adresse2")
	private String adresse2 ;
	
	@Column(name = "ville")
	private String ville ;
	
	@Column(name = "codePostale")
	private String codePostale ;
	
	@Column(name = "pays")
	private String pays ;
}

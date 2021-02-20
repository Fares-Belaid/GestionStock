package com.fares.gestiondestock.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Fournisseur extends AbstractEntity {

	@Column(name="nom")
	private String nom ;
	
	@Column(name="prenom")
	private String prenom ;
	
	@Embedded					// ma3neha champs composé tnajem testa3mlou f barcha classet
	private Adresse adresse ;
	
	@Column(name="photo")
	private String photo ;
	
	@Column(name="email")
	private String email ;
	
	@Column(name="numTel")
	private String numTel ;
	
	@OneToMany(mappedBy = "fournisseur")
	private List<CommandeFournisseur> commandeFournisseur;
}

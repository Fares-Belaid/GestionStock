package com.fares.gestiondestock.model;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Article extends AbstractEntity {

	@Column(name="codearticle")
	private String codeArticle;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="prixunitaireht")
	private BigDecimal prixUnitaireht;
	
	@Column(name="tauxtva")
	private BigDecimal tauxTva;
	
	@Column(name="prixunitairettc")
	private BigDecimal prixUnitaireTtc;
	
	@Column(name="photo")
	private String photo;
	
	@ManyToOne
	@JoinColumn(name="idcategory")
	private Category category ;
}

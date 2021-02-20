package com.fares.gestiondestock.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Category extends AbstractEntity {

	@Column(name="codecategory")
	private String codeCategory;
	
	@Column(name="designation")
	private String designation;
	
	@OneToMany(mappedBy = "category")
	private List<Article> articles ;
}

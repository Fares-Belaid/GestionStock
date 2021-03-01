package com.fares.gestiondestock.dto;

import java.math.BigDecimal;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneVenteDto {

	private Integer id;

	private VentesDto vente;
	
	private Integer idEntrprise;

	private BigDecimal quantite;
}

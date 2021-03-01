package com.fares.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MvtStkDto {

	private Integer id;

	private Integer idEntrprise;

	private ArticleDto article;
}

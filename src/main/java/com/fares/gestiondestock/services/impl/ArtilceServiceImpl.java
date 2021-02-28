package com.fares.gestiondestock.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fares.gestiondestock.exception.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fares.gestiondestock.dto.ArticleDto;
import com.fares.gestiondestock.exception.ErrorCodes;
import com.fares.gestiondestock.exception.InvalidEntityException;
import com.fares.gestiondestock.model.Article;
import com.fares.gestiondestock.repository.ArticleRepository;
import com.fares.gestiondestock.services.ArticleService;
import com.fares.gestiondestock.validator.ArticleValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArtilceServiceImpl implements ArticleService {

	private ArticleRepository articleRepository;
	
	@Autowired
	public ArtilceServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public ArticleDto save(ArticleDto dto) {
		List<String> errors = ArticleValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Article is not valid {}",dto);
			throw new InvalidEntityException("L'article ,'est pas valide", ErrorCodes.ARTICLE_NOT_VALID,errors);
		}
		return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
	}

	@Override
	public ArticleDto findById(Integer id) {
		if (id == null) {
			log.error("Article id is null");
			return null;
		}
		Optional <Article> article = articleRepository.findById(id);
		
		ArticleDto dto = ArticleDto.fromEntity(article.get());
		
		return Optional.of(dto).orElseThrow(() ->
			new EntityNotFoundException(
					"Aucun article avec l'id = "+ id + " n'ete touve dans la BD",
					ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		if (!StringUtils.hasLength(codeArticle)) {
			log.error("Article code is null");
			return null;
		}
Optional <Article> article = articleRepository.findArticleByCodeArticle(codeArticle);
		
		ArticleDto dto = ArticleDto.fromEntity(article.get());
		
		return Optional.of(dto).orElseThrow(() ->
			new EntityNotFoundException(
					"Aucun article avec le code = "+ codeArticle + " n'ete touve dans la BD",
					ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<ArticleDto> findAll() {
		
		return articleRepository.findAll().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Article id is null");
			return ;
		}
		articleRepository.deleteById(id);
	}

}

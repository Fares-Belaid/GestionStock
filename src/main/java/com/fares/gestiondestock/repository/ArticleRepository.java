package com.fares.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fares.gestiondestock.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	Optional <Article> findArticleByCodeArticle(String codeArticle);
	
}

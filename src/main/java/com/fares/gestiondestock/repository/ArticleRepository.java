package com.fares.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fares.gestiondestock.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	
}

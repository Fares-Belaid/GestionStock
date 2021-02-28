package com.fares.gestiondestock.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fares.gestiondestock.dto.ArticleDto;
import static com.fares.gestiondestock.utils.Constants.APP_ROOT;


public interface ArticleApi {

	@PostMapping(value = APP_ROOT +"/articles/create")
	ArticleDto save(@RequestBody ArticleDto dto);

	@GetMapping(value = APP_ROOT +"/articles/{idArticle}")
	ArticleDto findById(@PathVariable("idArticle") Integer id);

	@GetMapping(value = APP_ROOT +"/articles/{codeArticle}")
	ArticleDto findByCodeArticle(String codeArticle);

	@GetMapping(value = APP_ROOT +"/articles/all")
	List<ArticleDto> findAll();
	
	@DeleteMapping(value = APP_ROOT +"/articles/delete/{id}")
	void delete(Integer id);
}

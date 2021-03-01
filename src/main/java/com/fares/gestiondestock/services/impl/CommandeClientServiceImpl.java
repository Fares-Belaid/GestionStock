package com.fares.gestiondestock.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fares.gestiondestock.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fares.gestiondestock.dto.CommandeClientDto;
import com.fares.gestiondestock.dto.LigneCommandeClientDto;
import com.fares.gestiondestock.exception.ErrorCodes;
import com.fares.gestiondestock.exception.InvalidEntityException;
import com.fares.gestiondestock.model.Article;
import com.fares.gestiondestock.model.Client;
import com.fares.gestiondestock.model.CommandeClient;
import com.fares.gestiondestock.model.LigneCommandeClient;
import com.fares.gestiondestock.repository.ArticleRepository;
import com.fares.gestiondestock.repository.ClientRepository;
import com.fares.gestiondestock.repository.CommandeClientRepository;
import com.fares.gestiondestock.repository.LigneCommandeClientRepository;
import com.fares.gestiondestock.services.CommandeClientService;
import com.fares.gestiondestock.validator.CommandeClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {

	private CommandeClientRepository commandeClientRepository;
	private LigneCommandeClientRepository ligneCommandeClientRepository;
	private ClientRepository clientRepository;
	private ArticleRepository articleRepository;

	@Autowired
	public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository,
			ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository) {

		this.commandeClientRepository = commandeClientRepository;
		this.ligneCommandeClientRepository = ligneCommandeClientRepository;
		this.clientRepository = clientRepository;
		this.articleRepository = articleRepository;
	}

	@Override
	public CommandeClientDto save(CommandeClientDto dto) {

		List<String> errors = CommandeClientValidator.validate(dto);

		if (!errors.isEmpty()) {
			log.error("commande client n'est pas valide");
			throw new InvalidEntityException("commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID,
					errors);
		}
		
		Optional<Client> client = clientRepository.findById(dto.getClient().getId());
		if (client.isEmpty()) {
			log.error("client with Id {} was not found in the db", dto.getClient().getId());
			throw new EntityNotFoundException("acun client n'ete trouver avec cette id",ErrorCodes.CLIENT_NOT_FOUND);
		}
		List<String> articleErrors = new ArrayList<String>();
		
		if (dto.getLigneCommandeClient() != null) {
			dto.getLigneCommandeClient().forEach(ligCmdClt -> {
				if (ligCmdClt.getArticle() != null) {
					Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());	
					if (article.isEmpty()) {
						articleErrors.add("l'article avec l'id " + ligCmdClt.getArticle().getId()+ "n'existe pas");
					}
				}else {
					articleErrors.add("Impossible d'enregistrer une commande avec un article Null");
				}
			
			});
		}
			if(!articleErrors.isEmpty()) {
				log.warn("");
				throw new InvalidEntityException("article n'existe pas dans la bd", ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
			}
			
			CommandeClient savedCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(dto));
			
			dto.getLigneCommandeClient().forEach(ligCmdClt -> {
				LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
				ligneCommandeClient.setCommandeclient(savedCmdClt);
				ligneCommandeClientRepository.save(ligneCommandeClient);
			});
		
		return CommandeClientDto.fromEntity(savedCmdClt);
	}

	@Override
	public CommandeClientDto findById(Integer id) {
		if ( id == null) {
			log.error("commande client Id is null");
			return null;
		}
		return commandeClientRepository.findById(id)
				.map(CommandeClientDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("aucun commande client n'a ete trouve",ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public CommandeClientDto findByCode(String code) {

		if ( code == null) {
			log.error("commande client code is null");
			return null;
		}
		
		return commandeClientRepository.findCommandeByCode(code)
				.map(CommandeClientDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("aucun commande client n'a ete trouve",ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public List<CommandeClientDto> findAll() {

		return commandeClientRepository.findAll().stream().map(CommandeClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if ( id == null) {
			log.error("commande client code is null");
		}
		commandeClientRepository.deleteById(id);
	}

}

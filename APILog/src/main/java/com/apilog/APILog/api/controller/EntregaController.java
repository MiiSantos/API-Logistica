package com.apilog.APILog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apilog.APILog.api.assembler.EntregaAssembler;
import com.apilog.APILog.api.model.EntregaModel;
import com.apilog.APILog.domain.model.Entrega;
import com.apilog.APILog.domain.repository.EntregaRepository;
import com.apilog.APILog.domain.service.CriacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private CriacaoEntregaService criacaoEntregaservice;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private EntregaAssembler entregaAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody Entrega entrega) {
		Entrega entregaSolicitada = criacaoEntregaservice.solicitar(entrega);
		return entregaAssembler.toModel(entregaSolicitada);
	}
	
	@GetMapping
	public List<EntregaModel> listar() {
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega ->  ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
}

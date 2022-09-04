package com.apilog.APILog.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apilog.APILog.domain.exception.EntidadeNaoEncontradaException;
import com.apilog.APILog.domain.model.Entrega;
import com.apilog.APILog.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;

	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada!"));
	}
}
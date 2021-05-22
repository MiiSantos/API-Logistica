package com.apilog.APILog.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apilog.APILog.domain.exception.NegocioException;
import com.apilog.APILog.domain.model.Cliente;
import com.apilog.APILog.domain.repository.ClienteRepository;

@Service
public class CatalogoClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado!"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailExist = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		if(emailExist) {
			throw new NegocioException("Já existe um cadastro com esse email.");
		}
		return clienteRepository.save(cliente);	
	}
	
	@Transactional
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}
}

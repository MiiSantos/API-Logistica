package com.apilog.APILog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problema {

	private Integer status;
	private OffsetDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
	
	public static class Campo {
		private String nome;
		private String mensagem;
		public Campo(String nome, String mensagem) {
			super();
			this.nome = nome;
			this.mensagem = mensagem;
		}
		public String getNome() {
			return nome;
		}
		public String getMensagem() {
			return mensagem;
		}
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Campo> getCampos() {
		return campos;
	}
	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
	public OffsetDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}
}

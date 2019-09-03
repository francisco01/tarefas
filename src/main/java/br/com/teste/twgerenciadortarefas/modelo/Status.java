package br.com.teste.twgerenciadortarefas.modelo;

public enum Status {
	
	DISPONIVEL("Disponível"),
	AlUGADO("Alugado");
	
	private String estado;
	
	private Status(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}
	



}

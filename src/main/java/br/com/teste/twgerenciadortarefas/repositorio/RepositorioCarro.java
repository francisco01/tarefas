package br.com.teste.twgerenciadortarefas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.twgerenciadortarefas.modelo.Carro;

public interface RepositorioCarro extends JpaRepository<Carro, Long> {

}

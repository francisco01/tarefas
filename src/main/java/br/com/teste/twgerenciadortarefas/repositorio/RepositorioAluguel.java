package br.com.teste.twgerenciadortarefas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.twgerenciadortarefas.modelo.Aluguel;

public interface RepositorioAluguel extends JpaRepository<Aluguel, Long> {

}

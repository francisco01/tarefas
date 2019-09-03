package br.com.teste.twgerenciadortarefas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.twgerenciadortarefas.modelo.Cliente;

public interface RepositorioCliente extends JpaRepository<Cliente, Long> {

}

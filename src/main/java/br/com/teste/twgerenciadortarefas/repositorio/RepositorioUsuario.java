package br.com.teste.twgerenciadortarefas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.twgerenciadortarefas.modelo.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
}

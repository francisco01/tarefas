package br.com.teste.twgerenciadortarefas.modelo;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.teste.twgerenciadortarefas.repositorio.RepositorioCliente;

@Entity
@Table
public class Cliente{
	
//	@Autowired
//	RepositorioCliente repositorioCliente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Nome Obrigatório!")
	@Length(min = 8, message = "nome deve ter no minimo 8 caracteres")
	private String nome;
	@NotNull(message = "CPF Obrigatório!")
	@Length(min = 11, max = 11, message = "CPF deve conter 11 caracteres")
	private String CPF;
	@NotNull
	@Embedded
	private  Endereco endereco;
	@NotNull
	private String telefone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
//	public List<Cliente> listarClientes(){
//		return repositorioCliente.findAll();
//	}
//	

}

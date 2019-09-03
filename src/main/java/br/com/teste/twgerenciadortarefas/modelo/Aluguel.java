package br.com.teste.twgerenciadortarefas.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Aluguel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Date data_aluguel;
	@OneToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name="carro_id")
	private Carro carro;
	
	@Transient
	private List<Cliente> clientes  = new ArrayList<Cliente>();
	
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData_aluguel() {
		return data_aluguel;
	}
	public void setData_aluguel(Date data_aluguel) {
		this.data_aluguel = data_aluguel;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	

}

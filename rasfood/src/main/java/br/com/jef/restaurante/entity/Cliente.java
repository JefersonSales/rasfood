package br.com.jef.restaurante.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

	@EmbeddedId
	private ClienteId clienteId;

	private String nome;

	@Embedded
	private Contato contato;

	@OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private final List<Endereco> enderecos = new ArrayList<>();

	public Cliente(String cpf,String email, String nome) {
		 this.clienteId = new ClienteId(email, cpf);
		this.nome = nome;
	}

	public Cliente() {

	}

	public void addEndereco(Endereco endereco) {
		endereco.setClientes(this);
		this.enderecos.add(endereco);
	}

	public String getCpf() {
		return clienteId.getCpf();
	}

	public void setCpf(String cpf) {
		this.clienteId.setCpf(cpf);
	}

	public String getEmail() {
		return clienteId.getEmail();
	}

	public void setEmail(String email) {
		this.clienteId.setEmail(email);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"cpf='" + clienteId.getCpf() + '\'' +
				", email='" + clienteId.getEmail() + '\'' +
				", nome='" + nome + '\'' +
				", contato=" + contato +
				", enderecos=" + enderecos +
				'}';
	}
}

package br.com.jef.restaurante.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	private String cpf;

	private String nome;


	@OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private final List<Endereco> enderecos = new ArrayList<>();

	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public Cliente() {

	}

	public void addEndereco(Endereco endereco) {
		endereco.setClientes(this);
		this.enderecos.add(endereco);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"cpf='" + cpf + '\'' +
				", nome='" + nome + '\'' +
				", enderecos=" + enderecos +
				'}';
	}
}

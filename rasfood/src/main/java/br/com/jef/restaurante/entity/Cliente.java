package br.com.jef.restaurante.entity;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cpf;

	private String nome;

	private String cep;

	public Cliente(String cpf, String nome, String cep) {
		this.cpf = cpf;
		this.nome = nome;
		this.cep = cep;
	}

	public Cliente() {

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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"cpf='" + cpf + '\'' +
				", nome='" + nome + '\'' +
				", cep='" + cep + '\'' +
				'}';
	}
}

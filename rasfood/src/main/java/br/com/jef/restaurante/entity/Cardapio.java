package br.com.jef.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cardapio")
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private boolean disponivel;
	private BigDecimal valor;

	public Cardapio() {
	}

	public Cardapio(Integer id, String nome, String descricao, boolean disponivel, BigDecimal valor, Categoria categoria, Date dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.disponivel = disponivel;
		this.valor = valor;
		this.categoria = categoria;
		this.dataCriacao = dataCriacao;
	}

	@ManyToOne
	private Categoria categoria;

	private Date dataCriacao = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Cardapio{" +
				"id= " + id +
				", nome=' " + nome + '\'' +
				", descricao=' " + descricao + '\'' +
				", disponivel= " + disponivel +
				", valor= " + valor +
				", categoria= " + categoria +
				", dataCriacao= " + dataCriacao +
				'}';
	}
}

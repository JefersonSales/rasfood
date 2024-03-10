package br.com.jef.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Ordem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	@Column(name = "data_de_criacao")
	private LocalDateTime dataDeCriacao = LocalDateTime.now();

	@ManyToOne
	private Cliente cliente;

	@ManyToMany
	@JoinTable(name = "ordens_cardapios",
			joinColumns = @JoinColumn(name = "ordens_id"),
			inverseJoinColumns = @JoinColumn(name = "cardapios_id"))
	private List<Cardapio> cardapioList;

	public Ordem(Cliente cliente) {
		this.cliente = cliente;
	}

	public Ordem() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Ordem{" +
				"id=" + id +
				", valorTotal=" + valorTotal +
				", dataDeCriacao=" + dataDeCriacao +
				", cliente=" + cliente +
				'}';
	}
}
package br.com.jef.restaurante.dao;

import br.com.jef.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CardapioDao {

	private final EntityManager entityManager;

	public CardapioDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Cardapio cardapio) {
		entityManager.persist(cardapio);
	}

	public Cardapio consultarPorId(Integer id) {
		return entityManager.find(Cardapio.class, id);
	}

	public List<Cardapio> consultarProPreco(BigDecimal valor) {
		return entityManager.createQuery("SELECT c FROM Cardapio c WHERE c.valor = :valor", Cardapio.class)
				.setParameter("valor", valor).getResultList();
	}

	public List<Cardapio> consultarTodos() {
		try {
			String jpql = "SELECT c FROM Cardapio c";
			return entityManager.createQuery(jpql, Cardapio.class).getResultList();
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	public Cardapio consultarPorNome(String nome) {
		try {
			String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome)";
			return entityManager.createQuery(jpql, Cardapio.class).setParameter("nome", nome).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public void atualizar(Cardapio cardapio) {
		entityManager.merge(cardapio);
	}

	public void remover(Cardapio cardapio) {
		entityManager.remove(cardapio);
	}


}

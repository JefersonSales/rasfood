package br.com.jef.restaurante.dao;

import br.com.jef.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;

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

	public void atualizar(Cardapio cardapio) {
		entityManager.merge(cardapio);
	}

	public void remover(Cardapio cardapio) {
		entityManager.remove(cardapio);
	}


}

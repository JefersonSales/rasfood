package br.com.jef.restaurante.dao;

import br.com.jef.restaurante.entity.Ordem;
import br.com.jef.restaurante.vo.ItensPrincipaisVO;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {
	private final EntityManager entityManager;

	public OrdemDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Ordem ordem) {
		entityManager.persist(ordem);
	}

	public Ordem consultarPorId(Integer id) {
		return entityManager.find(Ordem.class, id);
	}

	public List<Ordem> consultarTodos() {
		return entityManager.createQuery("SELECT c FROM Ordem c", Ordem.class).getResultList();
	}

	public List<ItensPrincipaisVO> consultarItensPrincipais() {
		String jpql = "SELECT new br.com.jef.restaurante.vo.ItensPrincipaisVO(c.nome, SUM(oc.quantidade)) " +
				"FROM Ordem o JOIN OrdensCardapio oc on o.id = oc.cardapio.id" +
				"JOIN oc.cardapio c GROUP BY p.nomeORDER BY SUM(oc.quantidade) DESC";
		return this.entityManager.createQuery(jpql, ItensPrincipaisVO.class).getResultList();
	}

	public Ordem joinFetchCliente(final Integer id) {
		return entityManager.createQuery("SELECT o FROM Ordem o JOIN FETCH o.cliente WHERE o.id = :id ", Ordem.class).getSingleResult();
	}

	public void atualizar(Ordem ordem) {
		entityManager.merge(ordem);
	}

	public void remover(Ordem ordem) {
		entityManager.remove(ordem);
	}

}

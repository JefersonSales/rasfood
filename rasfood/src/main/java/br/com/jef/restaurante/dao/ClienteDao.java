package br.com.jef.restaurante.dao;

import br.com.jef.restaurante.entity.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {
	private final EntityManager entityManager;

	public ClienteDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Cliente cliente) {
		entityManager.persist(cliente);
	}

	public Cliente consultarPorId(Integer id) {
		return entityManager.find(Cliente.class, id);
	}

	public List<Cliente> consultarTodos() {
		return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
	}

	public List<Cliente> consultarPorNome(final String nome) {
		return entityManager.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class)
				.setParameter("nome", "%"+nome+"%").getResultList();
	}


	public void atualizar(Cliente cliente) {
		entityManager.merge(cliente);
	}

	public void remover(Cliente cliente) {
		entityManager.remove(cliente);
	}

}

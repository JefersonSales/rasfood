package br.com.jef.restaurante.dao;

import br.com.jef.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
	private final EntityManager entityManager;

	public CategoriaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Categoria categoria) {
		entityManager.persist(categoria);
	}

	public Categoria consultarPorId(Integer id) {
		return entityManager.find(Categoria.class, id);
	}

	public List<Categoria> consultarTodos() {
		return entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
	}

	public void atualizar(Categoria categoria) {
		entityManager.merge(categoria);
	}

	public void remover(Categoria categoria) {
		entityManager.remove(categoria);
	}

}

package br.com.jef.restaurante.dao;

import br.com.jef.restaurante.entity.Endereco;
import br.com.jef.restaurante.vo.ClienteVO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public class EnderecoDao {
	private final EntityManager entityManager;

	public EnderecoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Endereco endereco) {
		entityManager.persist(endereco);
	}

	public Endereco consultarPorId(Integer id) {
		return entityManager.find(Endereco.class, id);
	}

	public List<Endereco> consultarTodos() {
		return entityManager.createQuery("SELECT c FROM Endereco c", Endereco.class).getResultList();
	}

	public List<ClienteVO> consultarClientes(final String estado, final String cidade, final String rua) {
		String jpql = "SELECT new br.com.jef.restaurante.vo.ClienteVO(e.clientes.cpf, e.clientes.nome) " + "FROM Endereco e WHERE 1=1 ";
		if (Objects.nonNull(estado)) {
			jpql = jpql.concat("AND e.estado = :estado ");
		}
		if (Objects.nonNull(cidade)) {
			jpql = jpql.concat("AND e.cidade = :cidade ");
		}
		if (Objects.nonNull(rua)) {
			jpql = jpql.concat("AND e.rua = :rua ");
		}

		TypedQuery<ClienteVO> query = entityManager.createQuery(jpql, ClienteVO.class);

		if (Objects.nonNull(estado)) {
			query.setParameter("estado", estado);
		}
		if (Objects.nonNull(cidade)) {
			query.setParameter("cidade", cidade);
		}
		if (Objects.nonNull(rua)) {
			query.setParameter("rua", rua);
		}

		return query.getResultList();
	}

	public List<ClienteVO> consultarClientesUsandoCriteria(final String estado, final String cidade, final String rua) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ClienteVO> criteriaQuery = criteriaBuilder.createQuery(ClienteVO.class);
		Root<Endereco> root = criteriaQuery.from(Endereco.class);
		criteriaQuery.multiselect(root.get("cliente").get("cpf"), root.get("cliente").get("nome"));
		Predicate predicate = criteriaBuilder.and();

		if (Objects.nonNull(estado)) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.upper(root.get("estado")), estado));
		}

		if (Objects.nonNull(cidade)) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.upper(root.get("cidade")), cidade));
		}

		if (Objects.nonNull(rua)) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.upper(root.get("rua")), rua));
		}

		criteriaQuery.where(predicate);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public void atualizar(Endereco endereco) {
		entityManager.merge(endereco);
	}

	public void remover(Endereco endereco) {
		entityManager.remove(endereco);
	}

}

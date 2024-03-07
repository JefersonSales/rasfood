package br.com.jef.restaurante.service.teste;

import br.com.jef.restaurante.entity.Prato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PratoService {

	public static void main(String[] args) {
		Prato risoto = new Prato();
		risoto.setNome("Risoto de camarão");
		risoto.setDescricao("Risoto de camarão com queijo parmesão");
		risoto.setDisponivel(true);
		risoto.setValor(BigDecimal.valueOf(35.00));

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rasFood");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(risoto);
		entityManager.getTransaction().commit();
		entityManager.close();


	}
}

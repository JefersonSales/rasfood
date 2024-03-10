package br.com.jef.restaurante.service.teste;

import br.com.jef.restaurante.dao.CardapioDao;
import br.com.jef.restaurante.util.CargaDeDadosUtil;
import br.com.jef.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class CardapioService {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
		entityManager.getTransaction().begin();
		CargaDeDadosUtil.cadastrarCategorias(entityManager);
		CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

		CardapioDao cardapioDao = new CardapioDao(entityManager);
		//System.out.println("Lista de produtos por valor" + cardapioDao.consultarProPreco(BigDecimal.valueOf(10.00)));
		System.out.println("Consulta de produto por nome" + cardapioDao.consultarPorNome("Feijão"));
		entityManager.close();
	}

}

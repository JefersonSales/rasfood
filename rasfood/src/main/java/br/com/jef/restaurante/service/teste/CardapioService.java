package br.com.jef.restaurante.service.teste;

import br.com.jef.restaurante.dao.CardapioDao;
import br.com.jef.restaurante.dao.CategoriaDao;
import br.com.jef.restaurante.entity.Cardapio;
import br.com.jef.restaurante.entity.Categoria;
import br.com.jef.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
		cadastrarProdutoCardaprio(entityManager, cadastrarCategoria(entityManager));

	}

	private static Categoria cadastrarCategoria(EntityManager entityManager) {
		CategoriaDao categoriaDao = new CategoriaDao(entityManager);
		Categoria pratoPrincipal = new Categoria("Prato Principal");

		entityManager.getTransaction().begin();
		categoriaDao.cadastrar(pratoPrincipal);
		entityManager.getTransaction().commit();
		entityManager.clear();

		return pratoPrincipal;
	}

	private static void cadastrarProdutoCardaprio(EntityManager entityManager, Categoria categoria) {
		Cardapio risoto = new Cardapio();
		risoto.setNome("Risoto de camarão");
		risoto.setDescricao("Risoto de camarão com queijo parmesão");
		risoto.setDisponivel(true);
		risoto.setCategoria(categoria);
		risoto.setValor(BigDecimal.valueOf(35.00));

		Cardapio salmao = new Cardapio();
		salmao.setNome("Salmao grelhado");
		salmao.setDescricao("Salmao grelhado com molho de alcaparras e arroz branco");
		salmao.setDisponivel(true);
		salmao.setCategoria(categoria);
		salmao.setValor(BigDecimal.valueOf(68.00));

		CardapioDao cardapioDao = new CardapioDao(entityManager);
		entityManager.getTransaction().begin();

		cardapioDao.cadastrar(risoto);
		entityManager.flush();
		cardapioDao.cadastrar(salmao);
		entityManager.flush();
		System.out.println("O prato " + cardapioDao.consultarPorId(1) + " foi cadastrado com sucesso!");
		System.out.println("O prato " + cardapioDao.consultarPorId(2) + " foi cadastrado com sucesso!");

		entityManager.close();
	}
}

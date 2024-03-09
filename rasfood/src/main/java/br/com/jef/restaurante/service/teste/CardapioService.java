package br.com.jef.restaurante.service.teste;

import br.com.jef.restaurante.dao.CardapioDao;
import br.com.jef.restaurante.entity.Cardapio;
import br.com.jef.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

	public static void main(String[] args) {
		Cardapio risoto = new Cardapio();
		risoto.setNome("Risoto de camarão");
		risoto.setDescricao("Risoto de camarão com queijo parmesão");
		risoto.setDisponivel(true);
		risoto.setValor(BigDecimal.valueOf(35.00));

		Cardapio salmao = new Cardapio();
		risoto.setNome("Salmao grelhado");
		risoto.setDescricao("Salmao grelhado com molho de alcaparras e arroz branco");
		risoto.setDisponivel(true);
		risoto.setValor(BigDecimal.valueOf(35.00));

		EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
		CardapioDao cardapioDao = new CardapioDao(entityManager);
		entityManager.getTransaction().begin();
		cardapioDao.cadastrar(risoto);
		cardapioDao.cadastrar(salmao);
		entityManager.getTransaction().commit();
		entityManager.close();


	}
}

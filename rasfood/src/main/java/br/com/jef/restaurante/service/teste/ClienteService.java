package br.com.jef.restaurante.service.teste;

import br.com.jef.restaurante.dao.CardapioDao;
import br.com.jef.restaurante.dao.ClienteDao;
import br.com.jef.restaurante.dao.OrdemDao;
import br.com.jef.restaurante.entity.Cliente;
import br.com.jef.restaurante.entity.Endereco;
import br.com.jef.restaurante.entity.Ordem;
import br.com.jef.restaurante.entity.OrdensCardapio;
import br.com.jef.restaurante.util.CargaDeDadosUtil;
import br.com.jef.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

import static java.lang.System.out;

public class ClienteService {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManagerRasFood();
		em.getTransaction().begin();
		CargaDeDadosUtil.cadastrarCategorias(em);
		CargaDeDadosUtil.cadastrarProdutosCardapio(em);

		CardapioDao cardapioDao = new CardapioDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		OrdemDao ordemDao = new OrdemDao(em);

		Endereco endereco = new Endereco("61999999", "Rua 1", "Casa 1", "Brasília", "DF");
		Cliente cliente1 = new Cliente("1234567898", "Cliente 1");
		cliente1.addEndereco(endereco);
		Ordem ordem = new Ordem(cliente1);
		ordem.adicionarOrdensCardapio(new OrdensCardapio(ordem, cardapioDao.consultarPorId(1), 2));
		clienteDao.cadastrar(cliente1);
		ordemDao.cadastrar(ordem);
		out.println(ordem);
		em.getTransaction().commit();
		em.close();
	}
}

package br.com.jef.restaurante.util;

import br.com.jef.restaurante.dao.CardapioDao;
import br.com.jef.restaurante.dao.CategoriaDao;
import br.com.jef.restaurante.entity.Cardapio;
import br.com.jef.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {

	private CargaDeDadosUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static void cadastrarCategorias(EntityManager entityManager) {
		Categoria entrada = new Categoria("Entrada");
		Categoria salada = new Categoria("Salada");
		Categoria pratoPrincipal = new Categoria("Prato Principal");
		Categoria sobremesa = new Categoria("Sobremesa");
		Categoria bebida = new Categoria("Bebida");
		Categoria acompanhamento = new Categoria("Acompanhamento");

		CategoriaDao categoriaDao = new CategoriaDao(entityManager);

		categoriaDao.cadastrar(entrada);
		entityManager.flush();
		categoriaDao.cadastrar(salada);
		entityManager.flush();
		categoriaDao.cadastrar(pratoPrincipal);
		entityManager.flush();
		categoriaDao.cadastrar(sobremesa);
		entityManager.flush();
		categoriaDao.cadastrar(bebida);
		entityManager.flush();
		categoriaDao.cadastrar(acompanhamento);
		entityManager.flush();
	}

	public static void cadastrarProdutosCardapio(EntityManager entityManager) {
		CategoriaDao categoriaDao = new CategoriaDao(entityManager);
		CardapioDao cardapioDao = new CardapioDao(entityManager);

		List<Categoria> categorias = categoriaDao.consultarTodos();

		Cardapio moqueca = new Cardapio("Moqueca", "Peixe branco, banana da terra, arroz e farofa", true, BigDecimal.valueOf(95.00), categorias.get(2));
		Cardapio boboDeCamarao = new Cardapio("Bobó de Camarão", "Camarão, azeite de dendê, arroz e farofa", true, BigDecimal.valueOf(85.00), categorias.get(2));
		Cardapio saladaCaesar = new Cardapio("Salada Caesar", "Alface, croutons, parmesão e molho caesar", true, BigDecimal.valueOf(25.00), categorias.get(1));
		Cardapio saladaDeFrutas = new Cardapio("Salada de Frutas", "Frutas da estação", true, BigDecimal.valueOf(15.00), categorias.get(1));
		Cardapio cocaCola = new Cardapio("Coca-Cola", "Lata 350ml", true, BigDecimal.valueOf(5.00), categorias.get(4));
		Cardapio guarana = new Cardapio("Guaraná", "Lata 350ml", true, BigDecimal.valueOf(5.00), categorias.get(4));
		Cardapio arroz = new Cardapio("Arroz", "Arroz branco", true, BigDecimal.valueOf(15.00), categorias.get(5));
		Cardapio farofa = new Cardapio("Farofa", "Farofa de ovos", true, BigDecimal.valueOf(10.00), categorias.get(5));
		Cardapio feijao = new Cardapio("Feijão", "Feijão preto", true, BigDecimal.valueOf(20.00), categorias.get(5));
		Cardapio batataFrita = new Cardapio("Batata Frita", "Batata frita", true, BigDecimal.valueOf(10.00), categorias.get(5));
		Cardapio sorvete = new Cardapio("Sorvete", "Sorvete de creme", true, BigDecimal.valueOf(10.00), categorias.get(3));
		Cardapio pudim = new Cardapio("Pudim", "Pudim de leite", true, BigDecimal.valueOf(10.00), categorias.get(3));
		Cardapio mousse = new Cardapio("Mousse", "Mousse de chocolate", true, BigDecimal.valueOf(12.00), categorias.get(3));
		Cardapio bolo = new Cardapio("Bolo", "Bolo de cenoura", true, BigDecimal.valueOf(08.00), categorias.get(3));
		Cardapio cafe = new Cardapio("Café", "Café expresso", true, BigDecimal.valueOf(10.00), categorias.get(3));

		cardapioDao.cadastrar(moqueca);
		cardapioDao.cadastrar(boboDeCamarao);
		cardapioDao.cadastrar(saladaCaesar);
		cardapioDao.cadastrar(saladaDeFrutas);
		cardapioDao.cadastrar(cocaCola);
		cardapioDao.cadastrar(guarana);
		cardapioDao.cadastrar(arroz);
		cardapioDao.cadastrar(farofa);
		cardapioDao.cadastrar(feijao);
		cardapioDao.cadastrar(batataFrita);
		cardapioDao.cadastrar(sorvete);
		cardapioDao.cadastrar(pudim);
		cardapioDao.cadastrar(mousse);
		cardapioDao.cadastrar(bolo);
		cardapioDao.cadastrar(cafe);


		entityManager.flush();
		entityManager.clear();
	}

}

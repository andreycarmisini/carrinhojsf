package br.com.sematec.carrinhojsf.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.sematec.carrinhojsf.modelo.Item;
import br.com.sematec.carrinhojsf.modelo.Usuario;

public class ItemDAO extends DAO<Item> {

	private static ItemDAO instancia;

	public static synchronized ItemDAO getInstance() {
		if (instancia == null) {
			instancia = new ItemDAO();
		}
		return instancia;
	}

	private ItemDAO() {
		super(Item.class);
		geraDados();
	}

	private void geraIdEAdiciona(Usuario u, Item it) {
		List<Item> its = CarrinhoDAO.getInstance().getCarrinhos().get(u).getItens();
		boolean novoProd = true;
		for (Item i : its) {
			if (i.getProduto().getId().equals(it.getProduto().getId())) {
				novoProd = false;
				i.setQuantidade(i.getQuantidade() + it.getQuantidade());
				i.setTotal(i.getProduto().getPreco().multiply(new BigDecimal(i.getQuantidade())));
			}
		}

		if (novoProd) {
			Long id = it.getProduto().getId();
			it.setId(id);
			it.setTotal(it.getProduto().getPreco().multiply(new BigDecimal(it.getQuantidade())));

			CarrinhoDAO.getInstance().adiciona(u, it);

		}
	}

	public void adiciona(Usuario u, Item i) {
		geraIdEAdiciona(u, i);
	}

	@Override
	void geraDados() {

	}
}
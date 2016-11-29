package br.com.sematec.carrinhojsf.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.sematec.carrinhojsf.modelo.Carrinho;
import br.com.sematec.carrinhojsf.modelo.Item;
import br.com.sematec.carrinhojsf.modelo.Usuario;

public class CarrinhoDAO extends DAO<Carrinho> {

	public static synchronized CarrinhoDAO getInstance() {
		if (instancia == null) {
			instancia = new CarrinhoDAO();
		}
		return instancia;
	}

	private static CarrinhoDAO instancia;
	private Map<Usuario, Carrinho> CARRINHOS = new HashMap<Usuario, Carrinho>();

	private CarrinhoDAO() {
		super(Carrinho.class);
		geraDados();
	}

	public void adiciona(Usuario u, List<Item> i) {
		Carrinho c = CARRINHOS.get(u);
		if (c == null) {
			c = new Carrinho(new ArrayList<Item>(), new BigDecimal(0), u);
		}

		if (c.getItens().isEmpty()) {
			c.getItens().addAll(i);
		}
	}

	public void adiciona(Usuario u, Item i) {
		Carrinho c = CARRINHOS.get(u);
		if (c == null) {
			c = new Carrinho(new ArrayList<Item>(), new BigDecimal(0), u);
		}
		c.getItens().add(i);

	}

	public void novoCarrinho(Usuario u) {
		Carrinho c = CARRINHOS.get(u);
		if (c == null) {
			CARRINHOS.put(u, new Carrinho(new ArrayList<Item>(), new BigDecimal(0), u));
		}

	}

	public void remove(Usuario u, Item p) {
		Carrinho c = CARRINHOS.get(u);
		c.getItens().remove(p);
	}

	public Map<Usuario, Carrinho> getCarrinhos() {
		return CARRINHOS;
	}

	@Override
	void geraDados() {

	}

}
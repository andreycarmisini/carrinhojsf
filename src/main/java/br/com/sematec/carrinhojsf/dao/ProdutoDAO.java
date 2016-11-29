package br.com.sematec.carrinhojsf.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.sematec.carrinhojsf.modelo.Produto;

public class ProdutoDAO extends DAO<Produto> {

	private final static Map<Long, Produto> PRODUTOS = new HashMap<>();
	private static ProdutoDAO instancia;

	@Override
	protected void geraIdEAdiciona(Produto p) {
		Long id = Long.valueOf(PRODUTOS.size() + 1);
		p.setId(id);
		PRODUTOS.put(id, p);
	}

	public static synchronized ProdutoDAO getInstance() {
		if (instancia == null) {
			instancia = new ProdutoDAO();
		}
		return instancia;
	}

	private ProdutoDAO() {
		super(Produto.class);
		geraDados();
	}

	@Override
	public void atualiza(Produto p) {
		PRODUTOS.put(p.getId(), p);
	}

	public Produto find(Long id) {
		return PRODUTOS.get(id);
	}

	public List<Produto> lista() {
		return new ArrayList<Produto>(PRODUTOS.values());
	}

	@Override
	public void remove(Long id) {
		PRODUTOS.remove(id);
	}

	@Override
	public void remove(Produto p) {
		remove(p.getId());
	}

	@Override
	void geraDados() {
		geraIdEAdiciona(new Produto(1L, "Caneta", "http://www.mundoreal.xyz/wp-content/uploads/2015/11/Caneta-Bic.jpg",
				new BigDecimal(5)));
		geraIdEAdiciona(new Produto(2L, "Livro",
				"http://ponteseditores.com.br/loja/image/data/backgroun/livros-pontes.jpg", new BigDecimal(15)));
		geraIdEAdiciona(new Produto(3L, "Geladeira",
				"http://www.pontofrio-imagens.com.br/Eletrodomesticos/GeladeiraeRefrigerador/FrostFree/46706/5244305/Refrigerador-Brastemp-Frost-Free-Duplex-Clean-BRM39ER-352-L-Inox-46705.jpg",
				new BigDecimal(1000)));
		geraIdEAdiciona(new Produto(4L, "Videogame da Microsoft",
				"http://www.extra-imagens.com.br/Games/Xbox360/ConsolesXbox360/5573065/190290430/Console-Xbox-360-4GB-2-Controles-Wireless-5573065.jpg",
				new BigDecimal(200)));
		geraIdEAdiciona(new Produto(5L, "Samsung Novo ",
				"http://2.bp.blogspot.com/_zgAz60kWH2Q/TRWVPUM252I/AAAAAAAAEaA/AuelRbQ2u4Q/s1600/Samsung-GalaxyS-Main.jpg",
				new BigDecimal(500)));
	}
}
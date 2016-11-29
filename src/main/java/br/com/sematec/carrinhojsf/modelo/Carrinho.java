package br.com.sematec.carrinhojsf.modelo;

import java.math.BigDecimal;
import java.util.List;

public class Carrinho extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Item> itens;
	private BigDecimal total;

	public Carrinho(List<Item> itens, BigDecimal total, Usuario usuario) {
		super();
		this.itens = itens;
		this.total = total;
		this.usuario = usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public BigDecimal getTotal() {
		total = new BigDecimal(0);
		for (Item i : itens) {
			total = total.add(i.getTotal());
		}
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {

	}

}

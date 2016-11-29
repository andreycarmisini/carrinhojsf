package br.com.sematec.carrinhojsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.sematec.carrinhojsf.dao.CarrinhoDAO;
import br.com.sematec.carrinhojsf.dao.ItemDAO;
import br.com.sematec.carrinhojsf.modelo.Item;
import br.com.sematec.carrinhojsf.modelo.Produto;
import br.com.sematec.carrinhojsf.modelo.Usuario;

@ManagedBean
@ViewScoped
public class ItemBean {

	public void adiciona(Produto produto) {
		Item item = new Item();
		item.setProduto(produto);
		item.setQuantidade(Integer.valueOf(produto.getQuantidade()));
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario u = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");

		ItemDAO.getInstance().adiciona(u, item);
		// atualiza o carrinho na sessao
		String id = "carrinho" + u.getId();
		context.getExternalContext().getSessionMap().put(id, CarrinhoDAO.getInstance().getCarrinhos().get(u));

		produto.setQuantidade("1");
	}

}

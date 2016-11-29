package br.com.sematec.carrinhojsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.sematec.carrinhojsf.dao.CarrinhoDAO;
import br.com.sematec.carrinhojsf.modelo.Carrinho;
import br.com.sematec.carrinhojsf.modelo.Item;
import br.com.sematec.carrinhojsf.modelo.Usuario;

@ManagedBean
@ViewScoped
public class CarrinhoBean {

	private Carrinho carrinho;

	public Carrinho getCarrinho() {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario user = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		carrinho = CarrinhoDAO.getInstance().getCarrinhos().get(user);
		return carrinho;
	}

	public List<Item> lista() {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario user = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		Carrinho c = CarrinhoDAO.getInstance().getCarrinhos().get(user);
		return c.getItens();
	}

	public void remover(Item p) {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario user = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		CarrinhoDAO.getInstance().remove(user, p);
	}

	public void criarCarrinho(Usuario usuario) {
		CarrinhoDAO.getInstance().novoCarrinho(usuario);
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

}

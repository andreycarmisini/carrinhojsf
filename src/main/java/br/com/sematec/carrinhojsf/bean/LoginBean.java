package br.com.sematec.carrinhojsf.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.sematec.carrinhojsf.dao.CarrinhoDAO;
import br.com.sematec.carrinhojsf.dao.UsuarioDAO;
import br.com.sematec.carrinhojsf.modelo.Carrinho;
import br.com.sematec.carrinhojsf.modelo.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean {
	private Usuario usuario = new Usuario();

	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario u = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		String id = "carrinho" + u.getId();
		context.getExternalContext().getSessionMap().put(id, CarrinhoDAO.getInstance().getCarrinhos().get(u));
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}

	public String efetuaLogin() {
		System.out.println("Fazendo login do usuario " + this.usuario.getEmail());
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario existe = UsuarioDAO.getInstance().existe(this.usuario);
		if (existe != null) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", existe);
			String id = "carrinho" + existe.getId();

			Carrinho ver = (Carrinho) context.getExternalContext().getSessionMap().get(id);
			if (ver == null) {
				CarrinhoDAO.getInstance().novoCarrinho(existe);
				context.getExternalContext().getSessionMap().put(id,
						CarrinhoDAO.getInstance().getCarrinhos().get(existe));
			} else {
				CarrinhoDAO.getInstance().novoCarrinho(existe);
				CarrinhoDAO.getInstance().adiciona(existe, ver.getItens());
			}

			return "produtos?faces-redirect=true";
		}
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuario nao encontrado"));
		return "login?faces-redirect=true";
	}

	public String criarLogin() {
		System.out.println("Criando login do usuario " + this.usuario.getEmail());
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario existe = UsuarioDAO.getInstance().existe(this.usuario);
		if (existe != null) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", existe);
			String id = "carrinho" + existe.getId();

			Carrinho ver = (Carrinho) context.getExternalContext().getSessionMap().get(id);
			if (ver == null) {
				CarrinhoDAO.getInstance().novoCarrinho(existe);
				context.getExternalContext().getSessionMap().put(id,
						CarrinhoDAO.getInstance().getCarrinhos().get(existe));
			} else {
				CarrinhoDAO.getInstance().novoCarrinho(existe);
				CarrinhoDAO.getInstance().adiciona(existe, ver.getItens());
			}
			return "produtos?faces-redirect=true";
		} else {
			UsuarioDAO.getInstance().novo(this.usuario);
			Usuario existe2 = UsuarioDAO.getInstance().existe(this.usuario);
			context.getExternalContext().getSessionMap().put("usuarioLogado", existe2);
			String id = "carrinho" + existe2.getId();

			Carrinho ver = (Carrinho) context.getExternalContext().getSessionMap().get(id);
			if (ver == null) {
				CarrinhoDAO.getInstance().novoCarrinho(existe2);
				context.getExternalContext().getSessionMap().put(id,
						CarrinhoDAO.getInstance().getCarrinhos().get(existe2));
			} else {
				CarrinhoDAO.getInstance().novoCarrinho(existe2);
				CarrinhoDAO.getInstance().adiciona(existe2, ver.getItens());
			}
			return "produtos?faces-redirect=true";
		}
	}

	public String listaUsuarios() {
		return "usuarios?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}
}

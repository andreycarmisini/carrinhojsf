package br.com.sematec.carrinhojsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sematec.carrinhojsf.dao.UsuarioDAO;
import br.com.sematec.carrinhojsf.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	public List<Usuario> listaUsuarios() {
		return UsuarioDAO.getInstance().listaTodos();
	}
}

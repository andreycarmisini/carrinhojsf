package br.com.sematec.carrinhojsf.dao;

import org.apache.commons.lang3.StringUtils;

import br.com.sematec.carrinhojsf.modelo.Usuario;

public class UsuarioDAO extends DAO<Usuario> {
	public static synchronized UsuarioDAO getInstance() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}

	private static UsuarioDAO instancia;

	private UsuarioDAO() {
		super(Usuario.class);
		geraDados();
	}

	public Usuario existe(Usuario usuario) {
		Long i = 0l;
		boolean retorno = false;
		while (!retorno && i < LISTA.size()) {
			if (StringUtils.equalsIgnoreCase(LISTA.get(i).getEmail(), usuario.getEmail())
					&& StringUtils.equalsIgnoreCase(LISTA.get(i).getSenha(), usuario.getSenha())) {
				return LISTA.get(i);
			}
			i++;
		}
		return null;
	}

	@Override
	void geraDados() {
		geraIdEAdiciona(new Usuario("professor@sematecsolucoes.com.br", "professor", 1L));
		geraIdEAdiciona(new Usuario("diretor@sematecsolucoes.com.br", "diretor", 2L));
		geraIdEAdiciona(new Usuario("admin@admin.com", "admin", 3L));
		geraIdEAdiciona(new Usuario("teste@teste.com", "teste", 4L));
	}

	public void novo(Usuario usuario) {
		geraIdEAdiciona(
				new Usuario(usuario.getEmail(), usuario.getSenha(), Long.valueOf(this.listaTodos().size() + 1)));

	}
}

package br.com.sematec.carrinhojsf.modelo;

public class Usuario extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String email;
	private String senha;

	public Usuario() {

	}

	public Usuario(String email, String senha, Long id) {
		super();
		this.email = email;
		this.senha = senha;
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getSenha() {
		return senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

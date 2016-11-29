package br.com.sematec.carrinhojsf.modelo;

import java.math.BigDecimal;

public class Produto extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String imagem;
	private BigDecimal preco;

	// atributo criado para trabalhar com o componente p:selectOneMenu
	private String quantidade;

	public Produto() {
		super();
	}

	public Produto(Long id, String nome, String imagem, BigDecimal preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
		this.preco = preco;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

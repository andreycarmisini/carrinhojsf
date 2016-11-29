package br.com.sematec.carrinhojsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sematec.carrinhojsf.dao.ProdutoDAO;
import br.com.sematec.carrinhojsf.modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto selectedProduto;

	public List<Produto> listaProdutos() {
		return ProdutoDAO.getInstance().lista();
	}

	public Produto getSelectedProduto() {
		return selectedProduto;
	}

	public void setSelectedProduto(Produto selectedProduto) {
		this.selectedProduto = selectedProduto;
	}
}

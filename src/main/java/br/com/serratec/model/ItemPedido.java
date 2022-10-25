package br.com.serratec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Long idItemPedido;
	
	private Integer quantidade;

	@Transient
	private Double subTotal;
	
	@Column(name = "preco_venda")
	private Double precoVenda;

	public Long getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getSubTotal() {

		subTotal = precoVenda * quantidade;

		return subTotal;
	}

	

	
}

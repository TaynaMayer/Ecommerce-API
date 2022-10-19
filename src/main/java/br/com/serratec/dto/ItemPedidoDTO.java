package br.com.serratec.dto;

import javax.persistence.Column;

import br.com.serratec.model.ItemPedido;

public class ItemPedidoDTO {
	
	private Integer quantidade;
	
	@Column(name = "preco_venda")
	private Integer precoVenda;

	public ItemPedidoDTO() {
		
	}

	public ItemPedidoDTO(ItemPedido itemPedido) {
		super();
		this.quantidade = itemPedido.getQuantidade();
		this.precoVenda = itemPedido.getPrecoVenda();
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Integer precoVenda) {
		this.precoVenda = precoVenda;
	}
}

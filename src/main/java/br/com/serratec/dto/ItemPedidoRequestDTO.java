package br.com.serratec.dto;

import br.com.serratec.model.ItemPedido;

public class ItemPedidoRequestDTO {
	
	private Integer quantidade;
	
	private Double precoVenda;
	
	public ItemPedidoRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public ItemPedidoRequestDTO(ItemPedido itemPedido) {
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

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	
}

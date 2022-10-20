package br.com.serratec.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.serratec.model.ItemPedido;

public class ItemPedidoResponseDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItemPedido;
	
	private List<ItemPedido> itensPedidos = new ArrayList<>();
	
	private Integer quantidade;
	
	@Column(name = "preco_venda")
	private Integer precoVenda;

	public ItemPedidoResponseDTO() {
		
	}

	public ItemPedidoResponseDTO(ItemPedido itemPedido) {
		super();
		this.quantidade = itemPedido.getQuantidade();
		this.precoVenda = itemPedido.getPrecoVenda();
	}
	
	public Long getIdPedido() {
	    return idItemPedido;
	}
	
	public void setIdPedido(Long idItemPedido) {
	    this.idItemPedido = idItemPedido;
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

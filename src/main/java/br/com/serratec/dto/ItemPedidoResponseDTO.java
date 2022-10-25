package br.com.serratec.dto;

import java.util.ArrayList;
import java.util.List;

// import javax.persistence.Column;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

import br.com.serratec.model.ItemPedido;

public class ItemPedidoResponseDTO {
	
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItemPedido;
	
	private List<ItemPedido> itensPedidos = new ArrayList<>();
	
	private Integer quantidade;
	
	//@Column(name = "preco_venda")
	private Double precoVenda;

	private Integer valorTotal;

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

	

	public List<ItemPedido> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<ItemPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Long getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Integer getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

	
}

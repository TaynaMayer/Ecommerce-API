package br.com.serratec.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import br.com.serratec.model.Cliente;
import br.com.serratec.model.ItemPedido;
import br.com.serratec.model.Pedido;

public class PedidoResponseDTO {
	
	@Id
	private Long idPedido;		

	private LocalDate dataPedido;	
	
	private LocalDate dataEntrega;	
	
	private LocalDate dataEnvio;
	
	private String status;
	
	private List<ItemPedido> itens = new ArrayList<>();

	private Double valorTotal;

	private Cliente cliente;
	
	public PedidoResponseDTO() {
		
	}

	public PedidoResponseDTO(Pedido pedido) {
		super();
		this.idPedido = pedido.getIdPedido();
		this.dataPedido = pedido.getDataPedido();
		this.dataEntrega = pedido.getDataEntrega();
		this.dataEnvio = pedido.getDataEnvio();
		this.status = pedido.getStatus();
		this.valorTotal = pedido.getValorTotal();
		this.itens = pedido.getItens();
		this.cliente = pedido.getCliente();
	}
	
	

    public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getIdPedido() {
        return idPedido;
    }
    
    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}

package br.com.serratec.dto;

import java.time.LocalDate;

import br.com.serratec.model.Pedido;

public class PedidoInserirDTO {
	
	private LocalDate dataPedido;
	
	private LocalDate dataEntrega;
	
	private LocalDate dataEnvio;
	
	private String status;
	
	public PedidoInserirDTO() {
		// TODO Auto-generated constructor stub
	}

	public PedidoInserirDTO(Pedido pedido) {
		super();
		this.dataPedido = pedido.getDataPedido();
		this.dataEntrega = pedido.getDataEntrega();
		this.dataEnvio = pedido.getDataEnvio();
		this.status = pedido.getStatus();
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
}

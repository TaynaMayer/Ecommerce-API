package br.com.serratec.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import br.com.serratec.model.Pedido;

public class PedidoResponseDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	
	@Column(name = "data_pedido")
	private LocalDate dataPedido;
	
	@Column(name = "data_entrega")
	private LocalDate dataEntrega;
	
	@Column(name = "data_envio")
	private LocalDate dataEnvio;
	
	private String status;
	
	public PedidoResponseDTO() {
		
	}

	public PedidoResponseDTO(Pedido pedido) {
		super();
		this.dataPedido = pedido.getDataPedido();
		this.dataEntrega = pedido.getDataEntrega();
		this.dataEnvio = pedido.getDataEnvio();
		this.status = pedido.getStatus();
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
}

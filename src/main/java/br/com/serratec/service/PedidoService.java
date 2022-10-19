package br.com.serratec.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.PedidoReponseDTO;
import br.com.serratec.dto.PedidoRequestDTO;
import br.com.serratec.exception.EmailException;
import br.com.serratec.model.Pedido;
import br.com.serratec.repository.PedidoRepository;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;	

	
	public List<PedidoReponseDTO> listar() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoReponseDTO> pedidosDTO = new ArrayList<>();

		for (Pedido pedido : pedidos) {
			pedidosDTO.add(new PedidoReponseDTO(pedido));

		}
		return pedidosDTO;
		
	}

	public PedidoReponseDTO inserir(PedidoRequestDTO pedidoInserirDTO) {	
		
		Pedido pedido = new Pedido();
		pedido.setDataEntrega(pedidoInserirDTO.getDataEntrega());
		pedido.setDataEnvio(pedidoInserirDTO.getDataEnvio());
		pedido.setDataPedido(pedidoInserirDTO.getDataPedido());	
		pedido = pedidoRepository.save(pedido);
		
		return new PedidoReponseDTO(pedido);
		
	}

}

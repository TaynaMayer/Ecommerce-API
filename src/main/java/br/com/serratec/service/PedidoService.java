package br.com.serratec.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.PedidoReponseDTO;
import br.com.serratec.exception.EmailException;
import br.com.serratec.model.Pedido;
import br.com.serratec.repository.PedidoRepository;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;	
	
	@Autowired
	private MailConfig mailConfig;
	
	public List<PedidoReponseDTO> listar() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoReponseDTO> pedidosDTO = new ArrayList<>();

		for (Pedido pedido : pedidos) {
			pedidosDTO.add(new PedidoReponseDTO(pedido));

		}
		return pedidosDTO;
		
	}

	public PedidoReponseDTO inserir(PedidoRequestDTO pedidoInserirDTO) {
		if (pedidoRepository.findByEmail(pedidoInserirDTO.getEmail()) != null) {
			throw new EmailException("Email já existe na base");
		}
		Pedido pedido = new Pedido();
		pedido.setNome(pedidoInserirDTO.getNome());
		pedido.setEmail(pedidoInserirDTO.getEmail());
		pedido.setSenha(bCryptPasswordEncoder.encode(pedidoInserirDTO.getSenha()));
		pedido = pedidoRepository.save(pedido);
		for (PedidoPerfil up : pedidoInserirDTO.getPedidosPerfil()) {
			up.setPedido(pedido);
			up.setPerfil(perfilService.buscar(up.getPerfil().getIdPerfil()));
			up.setDataCriacao(LocalDate.now());			
		}
		pedidoPerfilRepository.saveAll(pedidoInserirDTO.getPedidosPerfil());		
		mailConfig.sendEmail(pedido.getEmail(), "Cadastro de Usuário", pedido.toString());
		return new PedidoReponseDTO(pedido);
	}

}

package br.com.serratec.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.serratec.dto.PedidoDTO;
import br.com.serratec.exception.EmailException;
import br.com.serratec.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> listar() {
		return ResponseEntity.ok(pedidoService.listar());
	}

	@PostMapping
	public ResponseEntity<Object> inserir(@Valid @RequestBody PedidoInserirDTO pedidoInserirDTO) {
		try {
			PedidoDTO pedidoDTO= pedidoService.inserir(pedidoInserirDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(pedidoDTO.getId()).toUri();
			return ResponseEntity.created(uri).body(pedidoDTO);

		} catch (EmailException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}

}

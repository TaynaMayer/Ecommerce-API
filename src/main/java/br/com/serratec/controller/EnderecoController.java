package br.com.serratec.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.serratec.exception.EmailException;
import br.com.serratec.service.EnderecoService;


@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> listar() {
		return ResponseEntity.ok(enderecoService.listar());
	}

	@PostMapping
	public ResponseEntity<Object> inserir(@RequestBody EnderecoInserirDTO enderecoInserirDTO) {
		try {
			EnderecoDTO enderecoDTO = enderecoService.inserir(enderecoInserirDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(enderecoDTO.getId()).toUri();
			return ResponseEntity.created(uri).body(enderecoDTO);

		} catch (EmailException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}

}
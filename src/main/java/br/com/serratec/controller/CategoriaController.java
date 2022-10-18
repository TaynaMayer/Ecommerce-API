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
import br.com.serratec.service.CategoriaService;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> listar() {
		return ResponseEntity.ok(categoriaService.listar());
	}

	@PostMapping
	public ResponseEntity<Object> inserir(@RequestBody CategoriaInserirDTO categoriaInserirDTO) {
		try {
			CategoriaDTO categoriaDTO = categoriaService.inserir(categoriaInserirDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(categoriaDTO.getId()).toUri();
			return ResponseEntity.created(uri).body(categoriaDTO);

		} catch (EmailException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}

}
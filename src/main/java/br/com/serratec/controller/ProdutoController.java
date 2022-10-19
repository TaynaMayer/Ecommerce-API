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
import br.com.serratec.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> buscarTodosDTO() {
        List<ProdutoDTO> listaProdutos = produtoService.buscarTodosDTO();
        return ResponseEntity.ok(listaProdutos);
        
	@PostMapping
	public ResponseEntity<Object> inserir(@RequestBody ProdutosInserirDTO produtoInserirDTO) {
		try {
			ProdutoDTO produtoDTO= produtoService.inserir(produtoInserirDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(produtoDTO.getId()).toUri();
			return ResponseEntity.created(uri).body(prudutoDTO);

		} catch (EmailException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Produto inserir(@RequestBody Produto produto) {
//		return produtoService.save(produto);
//		
//	}

}

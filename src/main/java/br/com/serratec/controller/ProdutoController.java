package br.com.serratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

		@Autowired
		private ProdutoService servico;

	    @GetMapping
	    public List<ProdutoResponseDTO> obterTodos(){
	        return servico.obterTodos();
	    }

	    @GetMapping("/{id}")
	    public Optional<ProdutoResponseDTO> oberPorId(@PathVariable Long id){
	        return  servico.obterPorId(id);
	    }

	    @PostMapping
	    public ProdutoResponseDTO inserir(@RequestBody ProdutoRequestDTO produto) {
	        return servico.cadastrar(produto);
	    }
	}

//	@GetMapping
//	public ResponseEntity<List<ProdutoDTO>> buscarTodosDTO() {
//        List<ProdutoDTO> listaProdutos = produtoService.buscarTodosDTO();
//        return ResponseEntity.ok(listaProdutos);
	
//	@GetMapping
//	public ResponseEntity<List<ProdutoDTO>> listar() {
//		return ResponseEntity.ok(produtoService.listar());
//	}

//	@GetMapping("/{id}")
//	public ResponseEntity<Produto> buscarUm(@PathVariable Long id) {
//		Optional<Produto> produto = produtoService.pesquisarUm(id);
//		if (produto.isPresent()) {
//			return ResponseEntity.ok(produto.get());
//		}
//		return ResponseEntity.notFound().build();
//	}

//	@PostMapping
//	public ResponseEntity<Object> inserir(@RequestBody ProdutoInserirDTO produtoInserirDTO) {
//		try {
//			ProdutoDTO produtoDTO = produtoService.inserir(produtoInserirDTO);
//			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtoDTO.getId())
//					.toUri();
//			return ResponseEntity.created(uri).body(produtoDTO);
//
//		} catch (EmailException e) {
//			return ResponseEntity.unprocessableEntity().body(e.getMessage());
//		}
//	}
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Produto inserir(@RequestBody Produto produto) {
//		return produtoService.save(produto);
//		
//	}
	
	

}

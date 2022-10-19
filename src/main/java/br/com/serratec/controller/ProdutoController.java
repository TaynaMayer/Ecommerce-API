package br.com.serratec.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.serratec.dto.ProdutoResponseDTO;
import br.com.serratec.dto.ProdutoRequestDTO;
import br.com.serratec.exception.EmailException;
import br.com.serratec.model.Produto;
import br.com.serratec.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        return ResponseEntity.ok(produtoService.listar());
    }

//	@GetMapping("/{id}")
//	public ResponseEntity<Produto> buscarUm(@PathVariable Long id) {
//		Optional<Produto> produto = produtoService.pesquisarUm(id);
//		if (produto.isPresent()) {
//			return ResponseEntity.ok(produto.get());
//		}
//		return ResponseEntity.notFound().build();
//	}

    @PostMapping
    public ResponseEntity<Object> inserir(@RequestBody ProdutoRequestDTO produtoInserirDTO) {
        try {
            ProdutoResponseDTO produtoDTO = produtoService.inserir(produtoInserirDTO);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(produtoDTO.getIdProduto())
                    .toUri();
            return ResponseEntity.created(uri).body(produtoDTO);

        } catch (EmailException e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

    }
}
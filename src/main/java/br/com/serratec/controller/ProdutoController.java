package br.com.serratec.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.serratec.dto.ProdutoResponseDTO;
import br.com.serratec.dto.ProdutoRequestDTO;
import br.com.serratec.exception.EmailException;
import br.com.serratec.model.Foto;
import br.com.serratec.service.FotoService;
import br.com.serratec.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private FotoService fotoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        return ResponseEntity.ok(produtoService.listar());
    }

    
    @GetMapping("/{id}")
    public Optional<ProdutoResponseDTO> oberPorId(@PathVariable Long id){
        return  produtoService.obterPorId(id);
   }
    
    
    @GetMapping("/{id}/foto")
    public ResponseEntity<byte[]> buscarPorFoto(@PathVariable Long id) {
        Foto foto = fotoService.buscar(id);
        HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.add("content-type", foto.getTipo());
        httpHeaders.add("content-length", String.valueOf(foto.getDados().length));
        return new ResponseEntity<>(foto.getDados(), httpHeaders, HttpStatus.OK);
    }

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
    
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id, @RequestBody ProdutoRequestDTO produto) {
        ProdutoResponseDTO dto = produtoService.atualizar(id, produto);        
        return ResponseEntity.ok(dto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        produtoService.deletar(id);        
        return ResponseEntity.ok("O id:" + id + " foi deletado com sucesso!"); // 200
    }
    
    
    
    
}
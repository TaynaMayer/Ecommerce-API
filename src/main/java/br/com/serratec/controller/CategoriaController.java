package br.com.serratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.serratec.dto.CategoriaRequestDTO;
import br.com.serratec.dto.CategoriaResponseDTO;
import br.com.serratec.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService servico;
	
	@GetMapping
	public ResponseEntity<List<CategoriaResponseDTO>> obterTodos(){
		return ResponseEntity.ok(servico.obterTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CategoriaResponseDTO>> oberPorId(@PathVariable Long id){
		return  ResponseEntity.ok(servico.obterPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaResponseDTO> cadastrar(@RequestBody CategoriaRequestDTO categoria) {
		CategoriaResponseDTO dto = servico.cadastrar(categoria);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaResponseDTO> atualizar( @PathVariable Long id, @RequestBody CategoriaRequestDTO categoria) {
		CategoriaResponseDTO dto = servico.atualizar(id, categoria);		
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(Long id){
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
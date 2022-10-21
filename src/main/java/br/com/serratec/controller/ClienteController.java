package br.com.serratec.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import br.com.serratec.dto.ClienteRequestDTO;
import br.com.serratec.dto.ClienteResponseDTO;
import br.com.serratec.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
	private ClienteService servico;
	
	@GetMapping
	public ResponseEntity<List<ClienteResponseDTO>> obterTodos(){
		return ResponseEntity.ok(servico.obterTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ClienteResponseDTO>> oberPorId(@PathVariable Long id){
		return  ResponseEntity.ok(servico.obterPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<ClienteResponseDTO> cadastrar(@Valid @RequestBody ClienteRequestDTO cliente) {
		ClienteResponseDTO dto = servico.cadastrar(cliente);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteResponseDTO> atualizar( @PathVariable Long id, @Valid @RequestBody ClienteRequestDTO cliente) {
		ClienteResponseDTO dto = servico.atualizar(id, cliente);		
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(Long id){
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

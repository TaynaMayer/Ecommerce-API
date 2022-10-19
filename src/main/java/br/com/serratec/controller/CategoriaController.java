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

import br.com.serratec.dto.CategoriaRequestDTO;
import br.com.serratec.dto.CategoriaResponseDTO;
import br.com.serratec.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService servico;
	
	@GetMapping
	public List<CategoriaResponseDTO> obterTodos(){
		return servico.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Optional<CategoriaResponseDTO> oberPorId(@PathVariable Long id){
		return  servico.obterPorId(id);
	}
	
	@PostMapping
	public CategoriaResponseDTO cadastrar(@RequestBody CategoriaRequestDTO categoria) {
		return servico.cadastrar(categoria);
	}
}
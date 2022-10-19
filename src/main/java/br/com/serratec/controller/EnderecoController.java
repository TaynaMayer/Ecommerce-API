package br.com.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.EnderecoDTO;
import br.com.serratec.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    
    @Autowired
    EnderecoService enderecoService;

    @GetMapping("{cep}")

	//@ApiOperation

    public ResponseEntity<EnderecoDTO> buscarCep(@PathVariable String cep) {
		EnderecoDTO endereco = enderecoService.buscar(cep);
		if (endereco == null) {
			return ResponseEntity.notFound().build();
	} else {
		return ResponseEntity.ok(endereco);
		}
	}
}

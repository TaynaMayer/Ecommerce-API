package br.com.serratec.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.serratec.dto.PedidoResponseDTO;
import br.com.serratec.dto.PedidoRequestDTO;
import br.com.serratec.exception.EmailException;
import br.com.serratec.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<PedidoResponseDTO>> listar() {
		return ResponseEntity.ok(pedidoService.listar());
	}
	
	 @GetMapping("/{id}")
	    public Optional<PedidoResponseDTO> oberPorId(@PathVariable Long id){
	        return  pedidoService.obterPorId(id);
	   }

	@PostMapping
	public ResponseEntity<Object> inserir(@Valid @RequestBody PedidoRequestDTO pedidoInserirDTO) {
		try {
			PedidoResponseDTO pedidoDTO= pedidoService.inserir(pedidoInserirDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(pedidoDTO.getIdPedido()).toUri();
			return ResponseEntity.created(uri).body(pedidoDTO);

		} catch (EmailException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> atualizar( @PathVariable Long id, @RequestBody PedidoRequestDTO categoria) {
        PedidoResponseDTO dto = pedidoService.atualizar(id, categoria);        
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(Long id){
        pedidoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
   
}

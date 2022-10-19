package br.com.serratec.controller;

// import java.util.List;
// import java.util.Optional;

// import javax.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.util.UriComponents;
// import org.springframework.web.util.UriComponentsBuilder;

// import br.com.serratec.dto.CategoriaDTO;
// import br.com.serratec.dto.CategoriaInserirDTO;
// import br.com.serratec.model.Categoria;
// import br.com.serratec.service.CategoriaService;



// @RestController
// @RequestMapping("/categorias")
// public class CategoriaController {
		
// 		@Autowired
// 		private CategoriaService categoriaService;
		
// 		@GetMapping
// 		public ResponseEntity<List<CategoriaDTO>> buscarTodos() {
// 			List<CategoriaDTO> listaCategorias = categoriaService.buscarTodos();
// 			return ResponseEntity.ok(listaCategorias);
// 		}
		
// 		@GetMapping("/{id}")
// 		public ResponseEntity<Categoria> pesquisarUm(@PathVariable Long id) {
// 			Optional<Categoria> categoria = categoriaService.buscarUm(id);
// 			if (categoria.isPresent()) {
// 				return ResponseEntity.ok(categoria.get());
// 			}
// 			return ResponseEntity.notFound().build();
// 		}
// }
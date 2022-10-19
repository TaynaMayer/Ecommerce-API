package br.com.serratec.service;

// import java.util.List;
// import java.util.Optional;

// import br.com.serratec.dto.CategoriaDTO;
// import br.com.serratec.dto.CategoriaInserirDTO;
// import br.com.serratec.model.Categoria;

// import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import br.com.serratec.repository.CategoriaRepository;

// @Service
// public class CategoriaService {

//     @Autowired
//     private CategoriaRepository categoriaRepository;
    
//     @Override
//     public List<CategoriaDTO> encontrarTodos() {
// 		List<Categoria> categorias = categoriaRepository.findAll();
// 		List<CategoriaDTO> categoriasDTO = new ArrayList<CategoriaDTO>();

// 		for (Categoria categoria : categorias) {
// 			CategoriaDTO categoriaDTO = new CategoriaDTO(categoria);
// 			categoriasDTO.add(categoriaDTO);
// 		}

// 		return categoriasDTO;
//     }

//     @Override
//     public List<Categoria> buscarTodos() {
//         return categoriaRepository.findAll();
//     }

//     @Override
//     public Optional<Categoria> buscarUm(Long id) {
//         return categoriaRepository.findById(id);
//     }

  }

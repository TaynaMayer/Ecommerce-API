package br.com.serratec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.model.Categoria;
import br.com.serratec.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Long id) {
		Optional<Categoria> perfil = categoriaRepository.findById(id);
		return perfil.get();
	}
}


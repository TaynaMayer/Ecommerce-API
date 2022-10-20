package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.model.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long> {

}

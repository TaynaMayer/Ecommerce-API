package br.com.serratec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    Cliente findByEmail(String email);

    Optional<Cliente> findByNome(String nome);

}

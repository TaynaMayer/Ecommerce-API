package br.com.serratec.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.ClienteRequestDTO;
import br.com.serratec.dto.ClienteResponseDTO;
import br.com.serratec.exception.ResourceBadRequestException;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.model.Cliente;
import br.com.serratec.repository.ClienteRepository;


@Service
public class ClienteService {
    @Autowired
	private ClienteRepository repositorio;
	
	public List<ClienteResponseDTO> obterTodos(){
		
		List<Cliente> clientes = repositorio.findAll();
		ModelMapper mapper = new ModelMapper();
		
		// Aqui eu pego a lista de Cliente (Modelo), e converto uma a uma em um ClienteResponseDTO.
		//No final devolvo a lista convertida.
		return clientes.stream()
				.map(cliente -> mapper.map(cliente, ClienteResponseDTO.class))
				.collect(Collectors.toList());
		
		
	}
	
	public Optional<ClienteResponseDTO> obterPorId(Long id){
		
		Optional<Cliente> optCliente = repositorio.findById(id);
		
		if(optCliente.isEmpty()) {
			//Aqui lanço um exception
			throw new ResourceNotFoundException("Não foi possível encontrar um cliente com id: " + id);
		}
		
		var clienteDTO = new ModelMapper().map(optCliente.get(), ClienteResponseDTO.class);
		
		return Optional.of(clienteDTO);

	}
	
	public ClienteResponseDTO cadastrar(ClienteRequestDTO clienteDto) {
		ModelMapper mapper = new ModelMapper();
		
		var clienteModel = mapper.map(clienteDto, Cliente.class);
		
		
		clienteModel.setIdCliente(null);
		clienteModel =  repositorio.save(clienteModel);
		
        if(clienteModel.getEmail() == null) {
			throw new ResourceBadRequestException("Deu ruim mano, esqueceu de passar o e-mail.");
		}

		return mapper.map(clienteModel, ClienteResponseDTO.class);
		
	}
	
	public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO clienteDTO){
		ModelMapper mapper = new ModelMapper();

		var clienteModel = mapper.map(clienteDTO, Cliente.class);

		clienteModel.setIdCliente(id);
		clienteModel =  repositorio.save(clienteModel);

		return mapper.map(clienteModel, ClienteResponseDTO.class);
	}

	public void deletar(Long id){
		var optCliente = obterPorId(id);

		if(optCliente.isEmpty()){
			//lancar exception
		}
		repositorio.deleteById(id);
	}
}

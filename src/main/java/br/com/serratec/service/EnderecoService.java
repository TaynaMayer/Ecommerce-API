package br.com.serratec.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import br.com.serratec.dto.EnderecoDTO;
import br.com.serratec.model.Endereco;
import br.com.serratec.model.Endereco;
import br.com.serratec.model.Cliente;
import br.com.serratec.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoDTO buscar(String cep) {
        Optional<Endereco> endereco = Optional.ofNullable(enderecoRepository.findByCep(cep));
        if (endereco.isPresent()) {
            return new EnderecoDTO(endereco.get());
        } else {
            RestTemplate rs = new RestTemplate();
            String uri = "http://viacep.com.br/ws/" + cep + "/json";
            Optional<Endereco> enderecoViaCep = Optional.ofNullable(rs.getForObject(uri, Endereco.class));
            if (enderecoViaCep.get().getCep() != null) {
                
               
                String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
                enderecoViaCep.get().setCep(cepSemTraco);
                
                return new EnderecoDTO(enderecoViaCep.get());
                
            } else {
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            }
        }
    }

    public Endereco inserir(String cep) {
        EnderecoDTO ent = buscar(cep);

        Endereco endereco = new Endereco();
        endereco.setBairro(ent.getBairro());
        endereco.setCep(ent.getCep());
        endereco.setIdEndereco(ent.getIdEndereco());
        endereco.setLogradouro(ent.getLogradouro());
        endereco.setLocalidade(ent.getLocalidade());
        endereco.setUf(ent.getUf());        

        endereco = enderecoRepository.save(endereco);

        return endereco;
    }
    
    
    
//    public Endereco inserir(Cliente cliente) throws IOException {
//        Endereco endereco = new Endereco();
//        endereco.setCep(endereco.getCep());
//        endereco.setBairro(endereco.getBairro());
//        endereco.setLocalidade(endereco.getLocalidade());
//        endereco.setLogradouro(endereco.getLogradouro());
//        endereco.setUf(endereco.getUf());
//        return enderecoRepository.save(endereco);
//    }


        
	

}
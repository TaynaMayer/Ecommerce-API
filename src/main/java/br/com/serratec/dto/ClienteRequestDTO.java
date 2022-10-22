package br.com.serratec.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import br.com.serratec.model.Cliente;
import br.com.serratec.model.Endereco;

public class ClienteRequestDTO {
	
    @Email(message = "Preencha o email corretamente, animal!")
	private String email;
	
	private String nomeUsuario;
	
	private String nomeCompleto;
	
	private Long idCliente;
	
	@CPF(message = "Preencha o CPF corretamente...")
	private String cpf;
	
	private String telefone;
	
	private Endereco endereco;
	
	private LocalDate dataNascimento;
	
	public ClienteRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public ClienteRequestDTO(Cliente cliente) {
		super();
		this.email = cliente.getEmail();
		this.nomeUsuario = cliente.getNomeUsuario();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.dataNascimento = cliente.getDataNascimento();
		this.endereco = cliente.getEndereco();
		}	
	
	


    
	
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}

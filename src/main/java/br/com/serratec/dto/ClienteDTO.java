package br.com.serratec.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;

import br.com.serratec.model.Cliente;
import br.com.serratec.model.Endereco;

public class ClienteDTO {
	
	private String email;
	
	@Column(name = "nome_usuario")
	private String nomeUsuario;
	
	@Column(name = "nome_completo")
	private String nomeCompleto;
	
	private String cpf;
	
	private String telefone;
	
	@Embedded
	private Endereco endereco;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	public ClienteDTO() {
		// TODO Auto-generated constructor stub
	}

	public ClienteDTO(Cliente cliente) {
		super();
		this.email = cliente.getEmail();
		this.nomeUsuario = cliente.getNomeUsuario();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.dataNascimento = cliente.getDataNascimento();
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
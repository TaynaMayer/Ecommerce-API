package br.com.serratec.dto;

import br.com.serratec.model.Categoria;

public class CategoriaRequestDTO {

	private String nome;
	
	private String descricao;
	
	public CategoriaRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaRequestDTO(Categoria categoria) {
		super();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

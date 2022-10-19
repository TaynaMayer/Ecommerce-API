package br.com.serratec.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.serratec.config.EmailConfig;
import br.com.serratec.dto.ProdutoResponseDTO;

import br.com.serratec.model.Produto;
import br.com.serratec.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EmailConfig emailConfig;

	public List<ProdutoResponseDTO> listar() {
		List<Produto> produtos = produtoRepository.findAll();
		List<ProdutoResponseDTO> produtosDTO = new ArrayList<>();

		for (Produto produto : produtos) {
			produtosDTO.add(new ProdutoResponseDTO(produto));

		}
		return produtosDTO;
	}
	
	public Produto inserir(Produto produto) {
		produto.setIdProduto(null);
		return produtoRepository.save(produto);
	}	
}

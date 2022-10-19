package br.com.serratec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.serratec.dto.ProdutoRequestDTO;
import br.com.serratec.dto.ProdutoResponseDTO;
import br.com.serratec.model.Produto;
import br.com.serratec.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoResponseDTO> listar() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoResponseDTO> produtosDTO = new ArrayList<>();

        for (Produto produto : produtos) {
            produtosDTO.add(new ProdutoResponseDTO(produto));

        }
        return produtosDTO;
    }

    public ProdutoResponseDTO inserir(ProdutoRequestDTO produtoInserirDTO) {

        Produto produto = new Produto();
        produto.setCategoria(produtoInserirDTO.getCategoria());
        produto.setDataCadastro(produtoInserirDTO.getDataCadastro());
        produto.setDescricao(produtoInserirDTO.getDescricao());
        produto = produtoRepository.save(produto);

        return new ProdutoResponseDTO(produto);

    }
}

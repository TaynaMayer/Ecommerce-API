package br.com.serratec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.serratec.dto.PedidoResponseDTO;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.dto.ItemPedidoRequestDTO;
import br.com.serratec.dto.ItemPedidoResponseDTO;
import br.com.serratec.dto.PedidoRequestDTO;
import br.com.serratec.model.ItemPedido;
import br.com.serratec.model.Pedido;
import br.com.serratec.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    private ModelMapper mapper = new ModelMapper();


    public List<PedidoResponseDTO> listar() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoResponseDTO> pedidosDTO = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            pedidosDTO.add(new PedidoResponseDTO(pedido));

        }
        return pedidosDTO;

    }

    public Optional<PedidoResponseDTO> obterPorId(Long id) {

        Optional<Pedido> optPedido = pedidoRepository.findById(id);

        if (optPedido.isEmpty()) {
          //Aqui lanço um exception
            throw new ResourceNotFoundException("Não foi possível encontrar um pedido com id: " + id);
        }
        
        var pedidoDTO = new ModelMapper().map(optPedido.get(), PedidoResponseDTO.class);

        return Optional.of(pedidoDTO);

    }

    public PedidoResponseDTO inserir(PedidoRequestDTO pedidoInserirDTO) {

        Pedido pedido = new Pedido();
        pedido.setIdPedido(pedidoInserirDTO.getIdPedido());
        pedido.setDataEntrega(pedidoInserirDTO.getDataEntrega());
        pedido.setDataEnvio(pedidoInserirDTO.getDataEnvio());
        pedido.setDataPedido(pedidoInserirDTO.getDataPedido());
        pedido.setStatus(pedidoInserirDTO.getStatus());
        pedido.setCliente(pedidoInserirDTO.getCliente());
        pedido = pedidoRepository.save(pedido);

        return new PedidoResponseDTO(pedido);

    }


    public ItemPedidoResponseDTO inserirItemPedido(ItemPedidoRequestDTO itemPedidoDTO){

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoVenda(itemPedidoDTO.getPrecoVenda());
        itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
       
        return new ItemPedidoResponseDTO(itemPedido);

    }





    public PedidoResponseDTO atualizar(Long id, PedidoRequestDTO pedidoDto) {

        var pedidoModel = mapper.map(pedidoDto, Pedido.class);

        pedidoModel.setIdPedido(id);
        pedidoModel = pedidoRepository.save(pedidoModel);

        return mapper.map(pedidoModel, PedidoResponseDTO.class);
    }

    public void deletar(Long id) {
        var optPedido = obterPorId(id);

        if (optPedido.isEmpty()) {
          //Aqui lanço um exception
            throw new ResourceNotFoundException("Não foi possível encontrar um cliente com id: " + id);
        }

        pedidoRepository.deleteById(id);
    }

}

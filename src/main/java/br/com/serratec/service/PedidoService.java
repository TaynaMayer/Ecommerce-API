package br.com.serratec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.serratec.dto.PedidoResponseDTO;
import br.com.serratec.dto.PedidoRequestDTO;
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
            // Aqui lanço um exception
            // Not found
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
        pedido = pedidoRepository.save(pedido);

        return new PedidoResponseDTO(pedido);

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
            // Lançar uma exception
        }

        pedidoRepository.deleteById(id);
    }

}

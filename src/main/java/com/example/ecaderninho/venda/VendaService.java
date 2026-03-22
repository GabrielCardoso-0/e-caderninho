package com.example.ecaderninho.venda;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ecaderninho.cliente.Cliente;
import com.example.ecaderninho.cliente.ClienteRepository;
import com.example.ecaderninho.formapagamento.FormaPagamento;
import com.example.ecaderninho.formapagamento.FormaPagamentoRepository;
import com.example.ecaderninho.usuario.Usuario;
import com.example.ecaderninho.usuario.UsuarioRepository;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private final FormaPagamentoRepository formaPagamentoRepository;

    public VendaService(VendaRepository vendaRepository,
                        UsuarioRepository usuarioRepository,
                        ClienteRepository clienteRepository,
                        FormaPagamentoRepository formaPagamentoRepository) {
        this.vendaRepository = vendaRepository;
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    public VendaResponse salvar(VendaRequest request) {
        Venda venda = toEntity(request);
        return toResponse(vendaRepository.save(venda));
    }

    public List<VendaResponse> listar() {
        return vendaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<VendaResponse> listarPorUsuario(Long idUsuario) {
        return vendaRepository.findByUsuarioId(idUsuario)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<VendaResponse> listarPorCliente(Long idCliente) {
        return vendaRepository.findByClienteId(idCliente)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<VendaResponse> listarPorUsuarioEPago(Long idUsuario, Boolean pago) {
        return vendaRepository.findByUsuarioIdAndPago(idUsuario, pago)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public VendaResponse buscarPorId(Long id) {
        return toResponse(encontrarPorId(id));
    }

    public VendaResponse atualizar(Long id, VendaRequest request) {
        Venda existente = encontrarPorId(id);
        existente.setUsuario(buscarUsuario(request.getIdUsuario()));
        existente.setCliente(request.getIdCliente() != null ? buscarCliente(request.getIdCliente()) : null);
        existente.setFormaPagamento(buscarFormaPagamento(request.getIdFormaPagamento()));
        existente.setValor(request.getValor());
        existente.setObservacao(request.getObservacao());
        existente.setPago(request.getPago());
        return toResponse(vendaRepository.save(existente));
    }

    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

    // ---------- helpers privados ----------

    private Venda encontrarPorId(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }

    private Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    private Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    private FormaPagamento buscarFormaPagamento(Long id) {
        return formaPagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada"));
    }

    private Venda toEntity(VendaRequest request) {
        Venda v = new Venda();
        v.setUsuario(buscarUsuario(request.getIdUsuario()));
        v.setCliente(request.getIdCliente() != null ? buscarCliente(request.getIdCliente()) : null);
        v.setFormaPagamento(buscarFormaPagamento(request.getIdFormaPagamento()));
        v.setValor(request.getValor());
        v.setObservacao(request.getObservacao());
        v.setPago(request.getPago());
        return v;
    }

    private VendaResponse toResponse(Venda v) {
        VendaResponse response = new VendaResponse();
        response.setId(v.getId());
        response.setIdUsuario(v.getUsuario().getId());
        response.setNomeUsuario(v.getUsuario().getNome());
        response.setIdFormaPagamento(v.getFormaPagamento().getId());
        response.setDescricaoFormaPagamento(v.getFormaPagamento().getDescricao());
        response.setValor(v.getValor());
        response.setObservacao(v.getObservacao());
        response.setData(v.getData());
        response.setPago(v.getPago());

        // cliente é opcional
        if (v.getCliente() != null) {
            response.setIdCliente(v.getCliente().getId());
            response.setNomeCliente(v.getCliente().getNome());
        }

        return response;
    }
}
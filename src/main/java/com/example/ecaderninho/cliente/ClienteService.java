package com.example.ecaderninho.cliente;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ecaderninho.usuario.Usuario;
import com.example.ecaderninho.usuario.UsuarioRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;

    public ClienteService(ClienteRepository clienteRepository,
                          UsuarioRepository usuarioRepository) {
        this.clienteRepository = clienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ClienteResponse salvar(ClienteRequest request) {
        Cliente cliente = toEntity(request);
        return toResponse(clienteRepository.save(cliente));
    }

    public List<ClienteResponse> listar() {
        return clienteRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<ClienteResponse> listarPorUsuario(Long idUsuario) {
        return clienteRepository.findByUsuarioId(idUsuario)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ClienteResponse buscarPorId(Long id) {
        return toResponse(encontrarPorId(id));
    }

    public ClienteResponse atualizar(Long id, ClienteRequest request) {
        Cliente existente = encontrarPorId(id);
        existente.setNome(request.getNome());
        existente.setCpf(request.getCpf());
        existente.setUsuario(buscarUsuario(request.getIdUsuario()));
        return toResponse(clienteRepository.save(existente));
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    // ---------- helpers privados ----------

    private Cliente encontrarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    private Usuario buscarUsuario(Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    private Cliente toEntity(ClienteRequest request) {
        Cliente c = new Cliente();
        c.setNome(request.getNome());
        c.setCpf(request.getCpf());
        c.setUsuario(buscarUsuario(request.getIdUsuario()));
        return c;
    }

    private ClienteResponse toResponse(Cliente c) {
        ClienteResponse response = new ClienteResponse();
        response.setId(c.getId());
        response.setNome(c.getNome());
        response.setCpf(c.getCpf());
        response.setIdUsuario(c.getUsuario().getId());
        response.setNomeUsuario(c.getUsuario().getNome());
        return response;
    }
}
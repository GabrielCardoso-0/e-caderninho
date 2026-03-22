package com.example.ecaderninho.usuario;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponse salvar(UsuarioRequest request) {
        Usuario usuario = toEntity(request);
        return toResponse(repository.save(usuario));
    }

    public List<UsuarioResponse> listar() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public UsuarioResponse buscarPorId(Long id) {
        return toResponse(encontrarPorId(id));
    }

    public UsuarioResponse atualizar(Long id, UsuarioRequest request) {
        Usuario existente = encontrarPorId(id);

        existente.setNome(request.getNome());
        existente.setEmail(request.getEmail());
        existente.setEstabelecimento(request.getEstabelecimento());
        existente.setSenha(request.getSenha());

        return toResponse(repository.save(existente));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // ---------- helpers privados ----------

    private Usuario encontrarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    private Usuario toEntity(UsuarioRequest request) {
        Usuario u = new Usuario();
        u.setNome(request.getNome());
        u.setEmail(request.getEmail());
        u.setEstabelecimento(request.getEstabelecimento());
        u.setSenha(request.getSenha());
        return u;
    }

    private UsuarioResponse toResponse(Usuario u) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(u.getId());
        response.setNome(u.getNome());
        response.setEmail(u.getEmail());
        response.setEstabelecimento(u.getEstabelecimento());
        return response;
    }
}
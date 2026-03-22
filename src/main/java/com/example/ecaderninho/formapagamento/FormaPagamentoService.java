package com.example.ecaderninho.formapagamento;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormaPagamentoService {

    private final FormaPagamentoRepository repository;

    public FormaPagamentoService(FormaPagamentoRepository repository) {
        this.repository = repository;
    }

    public FormaPagamentoResponse salvar(FormaPagamentoRequest request) {
        FormaPagamento forma = toEntity(request);
        return toResponse(repository.save(forma));
    }

    public List<FormaPagamentoResponse> listar() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<FormaPagamentoResponse> listarAtivas() {
        return repository.findByAtivo(true)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public FormaPagamentoResponse buscarPorId(Long id) {
        return toResponse(encontrarPorId(id));
    }

    public FormaPagamentoResponse atualizar(Long id, FormaPagamentoRequest request) {
        FormaPagamento existente = encontrarPorId(id);
        existente.setDescricao(request.getDescricao());
        existente.setAtivo(request.getAtivo());
        return toResponse(repository.save(existente));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // ---------- helpers privados ----------

    private FormaPagamento encontrarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada"));
    }

    private FormaPagamento toEntity(FormaPagamentoRequest request) {
        FormaPagamento f = new FormaPagamento();
        f.setDescricao(request.getDescricao());
        f.setAtivo(request.getAtivo() != null ? request.getAtivo() : true);
        return f;
    }

    private FormaPagamentoResponse toResponse(FormaPagamento f) {
        FormaPagamentoResponse response = new FormaPagamentoResponse();
        response.setId(f.getId());
        response.setDescricao(f.getDescricao());
        response.setAtivo(f.getAtivo());
        return response;
    }
}
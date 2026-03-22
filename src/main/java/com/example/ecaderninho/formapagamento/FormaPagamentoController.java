package com.example.ecaderninho.formapagamento;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

    private final FormaPagamentoService service;

    public FormaPagamentoController(FormaPagamentoService service) {
        this.service = service;
    }

    @PostMapping
    public FormaPagamentoResponse criar(@RequestBody FormaPagamentoRequest request) {
        return service.salvar(request);
    }

    @GetMapping
    public List<FormaPagamentoResponse> listar() {
        return service.listar();
    }

    @GetMapping("/ativas")
    public List<FormaPagamentoResponse> listarAtivas() {
        return service.listarAtivas();
    }

    @GetMapping("/{id}")
    public FormaPagamentoResponse buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public FormaPagamentoResponse atualizar(@PathVariable Long id,
                                             @RequestBody FormaPagamentoRequest request) {
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
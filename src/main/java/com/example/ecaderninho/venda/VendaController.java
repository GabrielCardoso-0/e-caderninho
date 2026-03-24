package com.example.ecaderninho.venda;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @PostMapping
    public VendaResponse criar(@RequestBody VendaRequest request) {
        return service.salvar(request);
    }

    @GetMapping
    public List<VendaResponse> listar() {
        return service.listar();
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<VendaResponse> listarPorUsuario(@PathVariable Long idUsuario) {
        return service.listarPorUsuario(idUsuario);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<VendaResponse> listarPorCliente(@PathVariable Long idCliente) {
        return service.listarPorCliente(idCliente);
    }

    @GetMapping("/usuario/{idUsuario}/pago/{pago}")
    public List<VendaResponse> listarPorUsuarioEPago(@PathVariable Long idUsuario,
            @PathVariable Boolean pago) {
        return service.listarPorUsuarioEPago(idUsuario, pago);
    }

    @GetMapping("/{id}")
    public VendaResponse buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public VendaResponse atualizar(@PathVariable Long id,
            @RequestBody VendaRequest request) {
        return service.atualizar(id, request);
    }

    @PatchMapping("/{id}/pagamento")
    public VendaResponse registrarPagamento(
            @PathVariable Long id,
            @RequestParam BigDecimal valor) {
        return service.registrarPagamento(id, valor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

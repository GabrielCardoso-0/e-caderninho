package com.example.ecaderninho.venda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByUsuarioId(Long idUsuario);
    List<Venda> findByClienteId(Long idCliente);
    List<Venda> findByUsuarioIdAndPago(Long idUsuario, Boolean pago);
}
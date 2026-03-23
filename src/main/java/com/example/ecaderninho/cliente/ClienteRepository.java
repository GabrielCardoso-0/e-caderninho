package com.example.ecaderninho.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByUsuarioId(Long idUsuario);
    Optional<Cliente> findByContato(String contato);
List<Cliente> findByUsuarioIdAndContatoContainingIgnoreCase(Long idUsuario, String contato);
}
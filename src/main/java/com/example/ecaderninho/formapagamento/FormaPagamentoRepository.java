package com.example.ecaderninho.formapagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
    List<FormaPagamento> findByAtivo(Boolean ativo);
}
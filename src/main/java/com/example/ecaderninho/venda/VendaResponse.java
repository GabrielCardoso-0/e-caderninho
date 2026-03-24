package com.example.ecaderninho.venda;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VendaResponse {

    private Long id;
    private Long idUsuario;
    private String nomeUsuario;
    private Long idCliente;
    private String nomeCliente;
    private Long idFormaPagamento;
    private String descricaoFormaPagamento;
    private BigDecimal valor;
    private String observacao;
    private LocalDateTime data;
    private Boolean pago;
    private BigDecimal saldoDevedor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public Long getIdCliente() { return idCliente; }
    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public Long getIdFormaPagamento() { return idFormaPagamento; }
    public void setIdFormaPagamento(Long idFormaPagamento) { this.idFormaPagamento = idFormaPagamento; }

    public String getDescricaoFormaPagamento() { return descricaoFormaPagamento; }
    public void setDescricaoFormaPagamento(String descricaoFormaPagamento) { this.descricaoFormaPagamento = descricaoFormaPagamento; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }

    public Boolean getPago() { return pago; }
    public void setPago(Boolean pago) { this.pago = pago; }

    public BigDecimal getSaldoDevedor() { return saldoDevedor; }
    public void setSaldoDevedor(BigDecimal saldoDevedor) { this.saldoDevedor = saldoDevedor; }
}
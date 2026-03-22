package com.example.ecaderninho.venda;

import java.math.BigDecimal;

public class VendaRequest {

    private Long idUsuario;
    private Long idCliente;
    private Long idFormaPagamento;
    private BigDecimal valor;
    private String observacao;
    private Boolean pago;

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdCliente() { return idCliente; }
    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }

    public Long getIdFormaPagamento() { return idFormaPagamento; }
    public void setIdFormaPagamento(Long idFormaPagamento) { this.idFormaPagamento = idFormaPagamento; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public Boolean getPago() { return pago; }
    public void setPago(Boolean pago) { this.pago = pago; }
}
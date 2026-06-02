package com.rafasantosdevv.restauranteSpring.domain.entity;

import com.rafasantosdevv.restauranteSpring.domain.enums.formaPagamento;
import com.rafasantosdevv.restauranteSpring.domain.enums.statusPagamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private formaPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    private statusPagamento status = statusPagamento.PENDENTE;

    @Column(name = "codigo_transacao_externa")
    private String codigoTransacaoExterna;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @JoinColumn(name = "pedido_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    @PrePersist
    public void prePersist(){
        criadoEm = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public formaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(formaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public statusPagamento getStatus() {
        return status;
    }

    public void setStatus(statusPagamento status) {
        this.status = status;
    }

    public String getCodigoTransacaoExterna() {
        return codigoTransacaoExterna;
    }

    public void setCodigoTransacaoExterna(String codigoTransacaoExterna) {
        this.codigoTransacaoExterna = codigoTransacaoExterna;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}

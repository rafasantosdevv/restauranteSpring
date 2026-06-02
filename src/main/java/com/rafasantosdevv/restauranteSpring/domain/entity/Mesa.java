package com.rafasantosdevv.restauranteSpring.domain.entity;

import com.rafasantosdevv.restauranteSpring.domain.enums.statusMesa;
import jakarta.persistence.*;

@Entity
@Table(name = "mesas")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int numero;
    private String descricao;
    private int capacidade;

    @Enumerated(EnumType.STRING)
    private statusMesa status = statusMesa.LIVRE;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public statusMesa getStatus() {
        return status;
    }

    public void setStatus(statusMesa status) {
        this.status = status;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

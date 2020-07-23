package com.roronoadiogo.modulo01.model;

public class Conta {

    private Integer id;
    private Integer agencia;
    private String name;
    private Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Contas{" +
                "id=" + id +
                ", agencia=" + agencia +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

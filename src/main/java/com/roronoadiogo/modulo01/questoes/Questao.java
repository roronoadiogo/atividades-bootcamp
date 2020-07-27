package com.roronoadiogo.modulo01.questoes;

import com.roronoadiogo.modulo01.model.Conta;

import java.util.*;
import java.util.function.DoubleConsumer;

public class Questao {

    private final List<Conta> contaList;

    public Questao(List<Conta> contas) {
        this.contaList = contas;
    }

    public Double somaTotalAgencias() {
        return contaList.stream().mapToDouble(Conta::getBalance).sum();
    }

    public Long totalContasSaldo(Double saldo) {
        return contaList.stream().filter(s -> s.getBalance() >= saldo).count();
    }

    public Long numeroDeContasAgenciaMaiorSaldoCem(Integer agencia) {
        return contaList.stream().filter(s -> s.getAgencia().equals(agencia)).filter(x -> x.getBalance() >= 100).count();
    }

    public Integer agenciaComMaiorSaldo() {
        return contaList.stream().max(Comparator.comparing(Conta::getBalance)).orElseThrow(NoSuchElementException::new).getAgencia();
    }

    public Integer agenciaComMenorSaldo() {
        return contaList.stream().min(Comparator.comparing(Conta::getBalance)).orElseThrow(NoSuchElementException::new).getAgencia();
    }

    public String nomeClienteMaiorSaldoAgencia(Integer agencia) {
        return contaList.stream().filter(s -> s.getAgencia().equals(agencia)).max(Comparator.comparing(Conta::getBalance)).orElseThrow(NoSuchElementException::new).getName();
    }

    public String nomeClienteMenorSaldoAgencia(Integer agencia) {
        return contaList.stream().filter(s -> s.getAgencia().equals(agencia)).min(Comparator.comparing(Conta::getBalance)).orElseThrow(NoSuchElementException::new).getName();
    }

    public Long totalClienteAgencia(Integer agencia) {
        return contaList.stream().filter(s -> s.getAgencia().equals(agencia)).count();
    }

    public Long clientesComecamNome(String nome, Integer agencia) {

        return contaList.stream().filter(s->s.getAgencia().equals(agencia)).filter(s -> s.getName().contains(nome)).count();
    }

    public String[] clientesMenorSaldoAgencia(Integer agencia) {

        return  contaList.stream().filter(s -> s.getAgencia().equals(agencia))
                .sorted(Comparator.comparing(Conta::getBalance))
                .limit(3)
                .map(Conta::getName)
                .toArray(String[]::new);

    }

    //refazer
    public Double totalSaldoClienteAgencias() {

        var total = 0.0;

        total+= contaList.stream().filter(s -> s.getAgencia().equals(10)).mapToDouble(Conta::getBalance).max().orElseThrow();
        total+= contaList.stream().filter(s -> s.getAgencia().equals(33)).mapToDouble(Conta::getBalance).max().orElseThrow();
        total+= contaList.stream().filter(s -> s.getAgencia().equals(47)).mapToDouble(Conta::getBalance).max().orElseThrow();
        total+= contaList.stream().filter(s -> s.getAgencia().equals(25)).mapToDouble(Conta::getBalance).max().orElseThrow();

        return total;
    }
}
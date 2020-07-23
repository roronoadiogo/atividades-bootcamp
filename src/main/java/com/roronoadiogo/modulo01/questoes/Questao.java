package com.roronoadiogo.modulo01.questoes;

import com.roronoadiogo.modulo01.model.Conta;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

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

    public Long clientesComecamNome(String nome) {
        return contaList.stream().filter(s -> s.getName().startsWith(nome)).count();
    }

    //refazer
    public String[] clientesMenorSaldoAgencia(Integer agencia) {

        return contaList.stream().filter(s -> s.getAgencia().equals(agencia)).min(Comparator.comparing(Conta::getBalance))
                .stream().sorted(Comparator.comparing(Conta::getName)).map(Conta::getName).limit(2).toArray(String[]::new);

    }

    //refazer
    public Double somaSaldoClientesAgencia() {
        return contaList.stream().filter(s-> s.getAgencia()!=null).mapToDouble(Conta::getBalance).sum();
    }

}
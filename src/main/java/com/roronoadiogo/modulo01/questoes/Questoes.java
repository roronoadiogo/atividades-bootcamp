package com.roronoadiogo.modulo01.questoes;

import com.roronoadiogo.modulo01.model.Contas;

import java.util.List;

public class Questoes {

    private final List<Contas> contasList;

    public Questoes(List<Contas> contas) {
        this.contasList = contas;
    }

    public double somaTotalAgencias(){
        return contasList.stream().mapToDouble(Contas::getBalance).sum();
    }

}

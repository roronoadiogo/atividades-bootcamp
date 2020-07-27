package com.roronoadiogo.modulo01;

import com.google.gson.Gson;
import com.roronoadiogo.modulo01.connection.ConnectionHttp;
import com.roronoadiogo.modulo01.model.Conta;
import com.roronoadiogo.modulo01.questoes.Questao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class Modulo01 {

    private static final String URL = "https://igti-film.herokuapp.com/api/accounts";

    public static void main(String[] args) {

        var connector = new ConnectionHttp();
        var client = connector.getClient();
        var requestAccounts = connector.requestGet(URL);

        try {
            var response = client.send(requestAccounts, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == HttpURLConnection.HTTP_OK){

                var contas = new Gson().fromJson(response.body(), Conta[].class);

                List<Conta> contaList = Arrays.asList(contas);
                var questoes = new Questao(contaList);

                var builder = new StringBuilder()
                        .append("Q1: A Soma total dos depósitos \n")
                        .append(questoes.somaTotalAgencias()).append("\n")
                        .append("Q2: O número total de contas com mais de 100 reais de saldo é: \n")
                        .append(questoes.totalContasSaldo(100d)).append("\n")
                        .append("Q3: O número de contas com mais de 100 reais de saldo na agência 33 é: \n")
                        .append(questoes.numeroDeContasAgenciaMaiorSaldoCem(33)).append("\n")
                        .append("Q4: A agência com maior saldo é a: \n")
                        .append(questoes.agenciaComMaiorSaldo()).append("\n")
                        .append("Q5: A agência com o menor saldo é a \n")
                        .append(questoes.agenciaComMenorSaldo()).append("\n")
                        .append("Q6: Considere o cliente com o maior saldo em cada agência (caso haja mais de um cliente com o maior saldo, escolha apenas um). O valor total desses saldos é: \n")
                        .append(questoes.totalSaldoClienteAgencias()).append("\n")
                        .append("Q7: O nome do(a) cliente com o maior saldo na agência 10 é: \n")
                        .append(questoes.nomeClienteMaiorSaldoAgencia(10)).append("\n")
                        .append("Q8: O nome do(a) cliente com o menor saldo na agência 47 é: \n")
                        .append(questoes.nomeClienteMenorSaldoAgencia(47)).append("\n")
                        .append("Q9: Você deve mostrar os nomes dos três clientes com menor saldo da agência 47, separados por vírgula e em ordem crescente (do menor para o maior). Qual seria a sua saída do programa? \n")
                        .append(Arrays.toString(questoes.clientesMenorSaldoAgencia(47))).append("\n")
                        .append("Q10: Quantos clientes estão na agência 47? \n")
                        .append(questoes.totalClienteAgencia(47)).append("\n")
                        .append("Q11: Quantos clientes que tem Maria no nome estão na agencia 47? \n")
                        .append(questoes.clientesComecamNome("Maria",47)).append("\n");

                System.out.println(builder);

            }

        }catch (IOException | InterruptedException e){
            e.getMessage();
        }

    }

}

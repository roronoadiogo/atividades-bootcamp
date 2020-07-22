package com.roronoadiogo.modulo01;

import com.google.gson.Gson;
import com.roronoadiogo.modulo01.connection.ConnectionHttp;
import com.roronoadiogo.modulo01.model.Contas;
import com.roronoadiogo.modulo01.questoes.Questoes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Modulo01 {

    private static final String URL = "https://igti-film.herokuapp.com/api/accounts";

    public static void main(String[] args) {

        var connector = new ConnectionHttp();
        var client = connector.getClient();
        var requestAccounts = connector.requestGet(URL);

        try {
            var response = client.send(requestAccounts, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == HttpURLConnection.HTTP_OK){

                var contas = new Gson().fromJson(response.body(), Contas[].class);

                List<Contas> contasList = Arrays.asList(contas);
                var questoes = new Questoes(contasList);

                StringBuilder builder = new StringBuilder()
                        .append("Q1: A Soma total dos depósitos")
                        .append("\n")
                        .append(questoes.somaTotalAgencias());

                System.out.println(builder.toString());

            }

        }catch (IOException | InterruptedException e){
            e.getMessage();
        }

    }

}

package com.roronoadiogo.modulo01.connection;

import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

public class ConnectionHttp {

    public ConnectionHttp() {
    }

    public HttpClient getClient(){

        return HttpClient.newBuilder()
                .connectTimeout(Duration.ofMinutes(1))
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

    public HttpRequest requestGet(String url){

        return HttpRequest.newBuilder(URI.create(url))
                .GET()
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type","application/json")
                .build();
    }
}

package com.one.conversordemonedas.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MonedasApi {
    private static String keyApi = "c450a3cef1ae6082de7534c8";

    /*
    * Decolvera los valores equivalentes a otras denominaciones
    * */
    public static String obtenerValoresMoneda(String moneda)  {
        String direccion = "https://v6.exchangerate-api.com/v6/" +
                keyApi + "/latest/" +
                moneda;

        try {
            URI uri = URI.create(direccion);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e){
            throw  new RuntimeException(e);
        }
    }

}

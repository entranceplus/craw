package com.ep.LinkExtractor.utils;

import com.ep.LinkExtractor.Constants;
import com.ep.LinkExtractor.dao.CustomResponseDAOImpl;
import com.ep.LinkExtractor.dto.CustomResponseDTO;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpClientUtil extends CustomResponseDAOImpl {
    private static Gson gson;


    public HttpClientUtil() {
        gson = new Gson();
    }

    public String GET(String url) throws IOException {
        HttpClient httpClient;
        CustomResponseDTO customResponseDTO;
        HttpGet httpGet;
        HttpResponse httpResponse;
        StringBuffer response;
        String line;

        httpClient = HttpClientBuilder.create().build();

        httpGet = new HttpGet(url);
        httpGet.addHeader("User-Agent", Constants.USER_AGENT);
        httpResponse = httpClient.execute(httpGet);
       if (httpResponse.getStatusLine().getStatusCode() == 200) {

            BufferedReader br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

            response = new StringBuffer();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
           customResponseDTO = createCustomResponse(response.toString(),
                   true, httpResponse.getStatusLine().getStatusCode());
       } else {
           customResponseDTO = createCustomResponse("", false,
                    httpResponse.getStatusLine().getStatusCode());

        }
        return gson.toJson(customResponseDTO);
    }
}

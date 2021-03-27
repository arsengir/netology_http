package com.github.arsengir;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.io.IOException;
import java.util.List;

public class Main
{

    public static final String URI = "https://cat-fact.herokuapp.com/facts";
    public static final ObjectMapper mapper = new ObjectMapper()
            .registerModules(new JavaTimeModule(), new ParameterNamesModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    public static void main(String[] args ) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet(URI);

        CloseableHttpResponse response = httpClient.execute(request);

        List<CatFact> catFacts = mapper.readValue(response.getEntity().getContent(),
                new TypeReference<List<CatFact>>() {});

        // т.к. сайт больше не возвращает поле Upvotes, чтобы продемонстрировать работу с filter просто отфилтровал
        // один факт по _id
        catFacts.stream()
                .filter(e -> !e.get_id().equals("58e008800aac31001185ed07"))
                .forEach(System.out::println);

    }
}

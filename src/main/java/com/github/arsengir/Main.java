package com.github.arsengir;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main
{
    public static final String URI = "https://api.nasa.gov/planetary/apod?api_key=SF8ar4Yt40TD6cAZqC5axwz6LfUXkEaRIbeVMGLr";

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
        NasaFotoInfo nasaFotoInfo = mapper.readValue(response.getEntity().getContent(), NasaFotoInfo.class);

        String urlFoto = nasaFotoInfo.getUrl();
        String fileName = urlFoto.substring(urlFoto.lastIndexOf('/')+1);

        request = new HttpGet(urlFoto);
        response = httpClient.execute(request);

        try(BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fileName))) {
            byte[] data = new byte[1024];
            int count;
            while ((count = response.getEntity().getContent().read(data, 0, 1024)) != -1) {
                bout.write(data, 0, count);
            }
        }
    }
}

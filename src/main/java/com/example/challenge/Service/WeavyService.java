package com.example.challenge.Service;

import net.minidev.json.JSONObject;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeavyService {
    @Value("${weavy.api.base-url}")
    private String baseUrl;

    @Value("${weavy.api.token}")
    private String bearerToken;

    private final OkHttpClient httpClient = new OkHttpClient();

    //create user
    public String createUser(String username, String password) throws IOException {
        JSONObject json = new JSONObject();
        json.put("UserName", username);
        json.put("Password", password);

        RequestBody body = RequestBody.create(
                json.toString(), MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
                .url(baseUrl)
                .post(body)
                .addHeader("Authorization", "Bearer" + bearerToken)
                .addHeader("Content-Type", "application/json")
                .build();

        return executeRequest(request);
    }

    private String executeRequest(Request request) throws IOException {
        try (Response response = httpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }
}

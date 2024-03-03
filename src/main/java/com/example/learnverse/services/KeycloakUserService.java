package com.example.learnverse.services;

import com.example.learnverse.dtos.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.http.impl.client.CloseableHttpClient;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;


public class KeycloakUserService {
    private final RestTemplate restTemplate;

    public KeycloakUserService() {
        String keycloakUrl = "http://localhost:8081"; // Replace with your Keycloak server URL

        // Add dependency for Apache HttpComponents Client 5
        HttpClient httpClient = HttpClient.newHttpClient(); // Assuming no specific configuration needed

        restTemplate = new RestTemplate();
//        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
//        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter()); // Add JSON message converter
    }

//    public String getAccessToken() {
//        String keycloakUrl = "http://localhost:8081/auth/realms/myReal/protocol/openid-connect/token";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        // Set client credentials (client ID and secret)
//        String clientId = "client";
//        String clientSecret = "cIrYBiDPvuWFbWz1UO9zKu8J71BfAPlx";
//
//        // Create the request body
//        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
//        requestBody.add("grant_type", "client_credentials");
//        requestBody.add("client_id", clientId);
//        requestBody.add("client_secret", clientSecret);
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
//
//        ResponseEntity<Map> response = restTemplate.postForEntity(keycloakUrl, requestEntity, Map.class);
//        if (response.getStatusCode().is2xxSuccessful()) {
//            return response.getBody().get("access_token").toString();
//        } else {
//            throw new RuntimeException("Error getting access token: " + response.getStatusCode());
//        }
//    }
public String getAccessToken() {
        String clientId = "client";
        String clientSecret = "cIrYBiDPvuWFbWz1UO9zKu8J71BfAPlx";
    String keycloakUrl = "http://localhost:8081/auth/realms/myRealm/protocol/openid-connect/token";
//    String credentials = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes(StandardCharsets.UTF_8));

    String credentials = clientId + ":" + clientSecret;
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Basic " + credentials);
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
    requestBody.add("grant_type", "client_credentials");

    HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

    Map<String, Object> responseBody;

    try {
        ResponseEntity<Map> response = restTemplate.exchange(
                keycloakUrl,
                HttpMethod.POST,
                requestEntity,
                Map.class
        );
        responseBody = response.getBody();
        if (response.getStatusCode().is2xxSuccessful()) {
            String accessToken = (String) responseBody.get("access_token");
            return accessToken;
            // Use the access token here
        } else {
            throw new RuntimeException("Error getting access token: " + response.getStatusCode());
        }
    } catch (RestClientException e) {
        // Handle potential exceptions during the request
    }
    return "";
}

    public void createUser(String accessToken, UserRequest userRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("username", "done");
        requestBody.add("email", "email.com");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        Map<String, Object> responseBody;

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    "http://127.0.0.1:8081/admin/realms/myRealm/users",
                    HttpMethod.POST,
                    requestEntity,
                    Map.class
            );
            responseBody = response.getBody();
            if (response.getStatusCode().is2xxSuccessful()) {
                ;
                // Use the access token here
            } else {
                throw new RuntimeException("Error getting access token: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            // Handle potential exceptions during the request
        }
    }


}

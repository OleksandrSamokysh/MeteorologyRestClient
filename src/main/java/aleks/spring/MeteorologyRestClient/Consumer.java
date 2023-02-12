package aleks.spring.MeteorologyRestClient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class Consumer {

    public static void main(String[] args) {

        String url = "http://localhost:8080/measurements/add";

        for (int i = 0; i < 10; i++) {
            postForObject(url, createDataJson());
        }
    }

    public static void postForObject (String url, Map<String, Object> jsonData) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(jsonData, headers);
        restTemplate.postForObject(url, request, String.class);
    }

    public static Map<String, Object> createDataJson () {

        Map<String, Object> jsonData = new HashMap<>();
        Random random = new Random();
        jsonData.put("value", random.nextDouble()*100 - random.nextInt(101));
        jsonData.put("raining", random.nextBoolean());
        jsonData.put("sensor", Map.of("name", "test3"));

        return jsonData;
    }

}

package pe.edu.cibertec.proyectoswa2.samav1.service.apirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    private final RestTemplate restTemplate;
    private final String apiUrl;

    public AuthService(RestTemplate restTemplate, @Value("${sping.external.service.base-url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    public String authenticate(String correo, String contraseña) {
        // Crear la solicitud de autenticación al endpoint del API
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Crear el objeto de solicitud con las credenciales
        Map<String, String> request = new HashMap<>();
        request.put("correo", correo);
        request.put("contraseña", contraseña);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(request, headers);

        // Hacer la llamada al endpoint de autenticación del API
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                apiUrl + "/api/auth/login",
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // Extraer el token de la respuesta
        String token = responseEntity.getBody();
        if (token != null) {
            return token;
        }
        return null;
    }
}

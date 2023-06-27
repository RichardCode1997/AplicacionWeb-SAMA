package pe.edu.cibertec.proyectoswa2.samav1.util;
import org.springframework.stereotype.Component;
@Component
public class TokenStorage {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void clearToken() {
        this.token = null;
    }
}

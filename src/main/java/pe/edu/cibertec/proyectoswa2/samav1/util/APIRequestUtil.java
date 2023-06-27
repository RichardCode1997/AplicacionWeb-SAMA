package pe.edu.cibertec.proyectoswa2.samav1.util;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;


public class APIRequestUtil {
    private final TokenStorage tokenStorage;

    public APIRequestUtil(TokenStorage tokenStorage) {
        this.tokenStorage = tokenStorage;
    }

    public void attachToken(HttpServletRequest request) {
        String token = tokenStorage.getToken();
        if (StringUtils.hasText(token)) {
            request.setAttribute("Authorization", "Bearer " + token);
        }
    }
}

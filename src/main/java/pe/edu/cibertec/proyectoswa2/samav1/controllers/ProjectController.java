package pe.edu.cibertec.proyectoswa2.samav1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.cibertec.proyectoswa2.samav1.models.Empleado;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.proyectoswa2.samav1.util.TokenStorage;
import pe.edu.cibertec.proyectoswa2.samav1.service.apirest.AuthService;
@Controller
public class ProjectController {

    private final RestTemplate restTemplate;
    private final AuthService authService;
    private final TokenStorage tokenStorage;
    public ProjectController(RestTemplate restTemplate, AuthService authService, TokenStorage tokenStorage) {
        this.restTemplate = restTemplate;
        this.authService = authService;
        this.tokenStorage = tokenStorage;
    }

    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("empleadoLogin",new Empleado());
        return "index";
    }

    @PostMapping("/home")
    public String login(@RequestParam("correo") String correo,
                        @RequestParam("contraseña") String contraseña) {
        // Llamar al AuthService para autenticar las credenciales y obtener el token JWT
        String token = authService.authenticate(correo, contraseña);

        // Guardar el token JWT en el TokenStorage
        tokenStorage.setToken(token);

        // Imprimir el token en la consola
        System.out.println("Token recibido 1ra vez: " + token);

        return "redirect:/home"; // Redireccionar a la página de inicio después del inicio de sesión exitoso
    }

    /*@PostMapping("/home")
    public String login(@ModelAttribute("empleadoLogin") Empleado empleadoLogin, Model model){
        if(empleadoLogin.getEmail().equals("carlos@gmail.com") && empleadoLogin.getPassw().equals("123")){
            return "home";
        }
        return "index";
    }*/


}

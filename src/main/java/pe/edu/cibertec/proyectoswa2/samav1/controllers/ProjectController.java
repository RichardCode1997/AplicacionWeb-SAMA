package pe.edu.cibertec.proyectoswa2.samav1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.proyectoswa2.samav1.models.Empleado;
@Controller
public class ProjectController {
    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("empleadoLogin",new Empleado());
        return "index";
    }
    @PostMapping("/home")
    public String login(@ModelAttribute("empleadoLogin") Empleado empleadoLogin, Model model){
        if(empleadoLogin.getEmail().equals("carlos@gmail.com") && empleadoLogin.getPassw().equals("123")){
            return "home";
        }
        return "index";
    }


}

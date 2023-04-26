package pe.edu.cibertec.proyectoswa2.samav1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.proyectoswa2.samav1.models.Empleado;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model){
//        model.addAttribute("empleadoLogin",new Empleado());
        return "home";
    }

    @GetMapping("/userdetails")
    public String userDetails(Model model){
//        model.addAttribute("empleadoLogin",new Empleado());
        return "usuario-detalle";
    }

}
